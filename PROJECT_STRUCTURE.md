# Project Structure: Student Management System

This document outlines the hierarchical organization of the project.

## 📁 Root Directory
| Folder | Responsibility |
|---|---|
| `main/` | Entry point and UI Interaction logic. |
| `model/` | Data transfer objects and entity definitions. |
| `service/` | Business logic and persistence orchestration. |
| `util/` | Shared validation and helper utilities. |

## 🏗️ Layered Architecture
The project follows a **Strict Layered Architecture** to promote scalability:

1. **Presentation Layer (`main`)**: Accepts user input and displays formatted reports.
2. **Business Layer (`service`)**: Processes commands and manages the data registry.
3. **Model Layer (`model`)**: Defines the structure of the data being moved.
4. **Cross-Cutting (`util`)**: Independent validation logic used by all layers.
