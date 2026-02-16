# Scientific Calculator (Android)
<img width="853" height="739" alt="Screenshot 2025-05-27 175631" src="https://github.com/user-attachments/assets/b62145e0-c494-4078-b32c-dcc161558b54" />
An Android scientific calculator app built with Java and AndroidX. It supports standard arithmetic operations plus scientific functions such as square root, trigonometric functions (sin, cos, tan), logarithms (log, ln), exponentiation, and percentage. The app also keeps a short history of recent calculations.

## Features

- **Standard calculator**: Addition, subtraction, multiplication, division, decimal input.
- **Scientific functions**: `sqrt`, `sin`, `cos`, `tan`, `log`, `ln`, power `^`, and percentage `%`.
- **Constants**: π and e buttons insert high-precision values.
- **Expression evaluator**: Custom recursive-descent parser (`ExpressionEvaluator`) to evaluate complex expressions with parentheses and operator precedence.
- **History panel**: Shows recent calculations (up to 20), scrollable within the main screen.

## Project Structure

- **`app/src/main/java/com/example/scientificcalculator/MainActivity.java`**: UI logic, button handling, and history management.
- **`app/src/main/java/com/example/scientificcalculator/ExpressionEvaluator.java`**: Expression parsing and evaluation.
- **`app/src/main/res/layout/activity_main.xml`**: Calculator layout and buttons.
- **`app/src/main/res/values*/themes.xml` & `colors.xml`**: Theming and colors.
- **`app/build.gradle` & root `build.gradle` / `settings.gradle`**: Gradle configuration.

## Requirements

- **Android Studio** (Giraffe or newer recommended).
- **Android Gradle Plugin** 8.x and **Gradle** 8.13 (configured via wrapper).
- **Compile SDK**: 34
- **Minimum SDK**: 21

## How to Build and Run

1. **Open the project**  
   - In Android Studio, choose **File → Open...** and select the `ScientificCalculator` folder.

2. **Let Gradle sync**  
   - Android Studio will automatically download the Gradle wrapper and sync dependencies.

3. **Run the app**  
   - Select an emulator or a connected Android device.  
   - Click **Run ▶** to install and launch the app.
