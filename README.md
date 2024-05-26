# Programming Assignment

This repository contains a Java project for a programming assignment. It includes classes representing address, department, student, assignment, course, gender, and a utility class for string manipulation.

## Overview

The project aims to demonstrate object-oriented programming concepts in Java. It includes classes to represent different entities such as addresses, departments, students, assignments, and courses. The classes are designed to interact with each other to simulate a simple educational system.

## Features

- **Address Class:** Represents an address with street number, street name, city, province, postal code, and country fields. It includes methods to validate postal codes and toString, equals, getter, and setter methods.
- **Department Class:** Represents a department with a department ID and name. It includes methods to validate department names and toString, equals, getter, and setter methods.
- **Student Class:** Represents a student with a student ID, name, gender, address, department, registered courses, and methods for course registration and dropping. It includes methods to convert to a simplified string, toString, equals, getter, and setter methods.
- **Assignment Class:** Represents an assignment with an assignment ID, name, weight, maximum score, average score, and scores array. It includes methods to calculate average score, generate random scores, and toString method.
- **Course Class:** Represents a course with a course ID, name, credits, department, assignments, registered students, final scores, and methods for registering students, adding assignments, generating scores, and displaying scores. It includes methods to check assignment weight validity, calculate student average, convert to a simplified string, toString, equals, getter, and setter methods.
- **Gender Enum:** Represents the gender of a person with values FEMALE and MALE.
- **Util Class:** Located in the util package, contains a method to convert strings to title case.
