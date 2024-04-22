package org.example;

import com.google.gson.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class JSONValidator {
    public boolean validate(String jsonFile) throws JSONValidationException {
        JsonObject jsonObject = readJsonFile(jsonFile);
        return isResourceFieldValid(jsonObject);
    }

    private JsonObject readJsonFile(String jsonFile) throws JSONValidationException {
        try (FileReader reader = new FileReader(jsonFile)) {
            return JsonParser.parseReader(reader).getAsJsonObject();
        } catch (FileNotFoundException e) {
            throw new JSONValidationException("JSON file not found: " + jsonFile, e);
        } catch (IOException e) {
            throw new JSONValidationException("Failed to read JSON file: " + jsonFile, e);
        } catch (JsonSyntaxException e) {
            throw new JSONValidationException("Invalid JSON format in file: " + jsonFile, e);
        }
    }

    private boolean isResourceFieldValid(JsonObject jsonObject) throws JSONValidationException {
        JsonObject policyDocument = jsonObject.getAsJsonObject("PolicyDocument");
        if (policyDocument == null) {
            throw new JSONValidationException("Missing 'PolicyDocument' in JSON data.");
        }

        JsonArray statements = policyDocument.getAsJsonArray("Statement");
        if (statements == null) {
            throw new JSONValidationException("Missing 'Statement' array in 'PolicyDocument'.");
        }

        for (JsonElement statementElement : statements) {
            if (!statementElement.isJsonObject()) {
                throw new JSONValidationException("Expected a JSON object for each statement.");
            }
            JsonObject statementObject = statementElement.getAsJsonObject();
            JsonElement resourceElement = statementObject.get("Resource");
            if (resourceElement == null) {
                throw new JSONValidationException("Missing 'Resource' field in a statement.");
            }

            String resource = resourceElement.getAsString();
            if ("*".equals(resource)) {
                return false;
            }
        }
        return true;
    }


}