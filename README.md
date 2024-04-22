# JSON Validator
This tool validates the structure of a JSON file based on predefined AWS IAM Role Policy specifications. It allows users to input the path to the JSON file via the command line and checks whether the Resource field in the JSON document does not contain the character '*'.

## Prerequisites
 - Java JDK 11 or later
 - Gradle

## Getting started
### Installation
1. Clone the repository
```bash
git clone https://github.com/klark142/json-validator.git
cd json-validator
```
2. Build the project
```bash
gradle build
```
3. Run the application
```bash
java -jar build/libs/json-validator.jar
```
### Usage
To validate a JSON file, run the program with the path to the JSON file as input. The path can be absolute or relative to the directory from which you run the application.
```bash
java -jar build/libs/json-validator.jar
```
When prompted, enter the full path to the JSON file you wish to validate:
```bash
Enter the path to the JSON file:
/path/to/your/file.json
```
The application will validate the JSON file and print the result:
- Validation result: true if the file meets all criteria.
- Validation result: false if any criteria are not met.
- If there are any issues accessing the file or if the JSON is malformed, an error message will be displayed.

## Testing
### Running tests
1. Naviagte to the project directory
```bash
cd path/to/json-validator
```
2. Use Gradle to run the tests. This command executes all tests included in the project:
```bash
gradle test
```
