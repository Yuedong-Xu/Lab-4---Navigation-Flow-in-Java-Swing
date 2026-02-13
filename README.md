# Lab 4 – Navigation Flow in Java Swing

## Overview

This lab demonstrates intermediate Java Swing concepts including panel navigation, data flow between panels, image handling, and implementation of the Model–View–Controller (MVC) architecture.

The application allows users to:

- Register user details in a form panel
- View the registered details in a separate view panel
- Navigate between panels using CardLayout

---

## Features Implemented

### 1. User Registration Form

The form collects the following required fields:

- First Name (JTextField)
- Last Name (JTextField)
- Age (JSpinner)
- Email (JFormattedTextField)
- Phone (JFormattedTextField with mask)
- Hobby (JTextArea)
- Continent (JComboBox)
- Photo (Image upload using JFileChooser)
- Date of Birth (JDateChooser) – Bonus feature

All fields include validation with appropriate error messages displayed in the UI.

---

### 2. MVC Architecture

The project follows MVC structure:

- **Model package**
  - `User.java`
  - Contains all attributes
  - Constructor assigns all instance variables
  - Getters & setters implemented
  - `toString()` method returns string representation (excluding photo)

- **UI package**
  - `FormJPanel` (Registration View)
  - `ViewJPanel` (Display View)
  - `MainJFrame` (Navigation controller using CardLayout)

---

### 3. Navigation Flow (Required)

Implemented using:

- `JSplitPane`
- `CardLayout`

Two views:

1. Registration Form
2. User Details View (all fields grayed out)

Navigation buttons:
- Form
- View

Data flows from:
Form → Model (User object) → View Panel

---

### 4. Validation Rules

The application validates:

- First and Last Name (letters only)
- Age (1–120)
- Email format
- Phone number completeness
- Continent selection
- Photo upload
- Date of Birth selection

Error messages are displayed using `JOptionPane`.

---

### 5. Bonus Feature (2 pts)

Date of Birth implemented using:

- `JDateChooser` from JCalendar library

The selected date is:
- Stored in the User model
- Displayed in the View panel
- Validated to ensure it is not null

---

## Technologies Used

- Java
- Java Swing
- CardLayout
- JSplitPane
- JFormattedTextField
- JSpinner
- JFileChooser
- JDateChooser (JCalendar library)

---

## How to Run

1. Clone the repository
2. Open in NetBeans
3. Ensure `jcalendar-x.x.x.jar` is added to Classpath
4. Run `MainJFrame`

---


## Conclusion

This lab helped reinforce:

- Swing layout management
- Data flow between panels
- MVC implementation
- Input validation
- Navigation using CardLayout



The application successfully meets all required criteria and includes the bonus date chooser feature.
Yuedong Xu

