**Class Diagram (Polymorphism changes)**

- **Overview**: This document describes the main abstract classes and their implemented subclasses after applying polymorphism principles for Practical Work №6.

- **Abstract classes**:
  - `Employee` : abstract base for all employee types.
    - Abstract methods:
      - `getRole()` : returns role name
      - `performDuties()` : executes role-specific actions (demo)
      - `getContactSummary()` : short contact info
  - `ProjectEntity` : abstract base for project-related entities.
    - Abstract methods:
      - `onStatusChanged()` : hook called when status changes
      - `start()` : start lifecycle
      - `pause()` : pause lifecycle
      - `complete()` : complete lifecycle
  - `OrganizationalUnit` : already abstract in the project and provides:
    - `activate()`
    - `deactivate()`
    - `getType()`

- **Concrete subclasses**:
  - `company.empoloyees.RegularEmployee` : general concrete employee used by the factory when a generic employee is needed.
  - `company.empoloyees.Admin`, `HRSpecialist`, `Manager` : concrete employee types implementing the `Employee` abstract methods.
  - `company.projects.Project` and `company.projects.Task` : concrete project entities implementing lifecycle methods from `ProjectEntity`.
  - `company.structure.Department` : concrete `OrganizationalUnit` implementation.

- **Key design notes**:
  - Callers now interact through abstract types where appropriate. Example: `Project` constructor accepts an `Employee` owner (abstract base) instead of a concrete `Manager` only.
  - `ObjectFactory` no longer instantiates `Employee` directly; it creates `RegularEmployee` which is a concrete subclass of `Employee`.
  - The `ProjectEntity` lifecycle methods (`start`, `pause`, `complete`) are abstract to demonstrate polymorphic lifecycle behavior across `Project` and `Task`.

- **Simple UML-like sketch**:

  ProjectEntity <|-- Project
  ProjectEntity <|-- Task
  Employee <|-- RegularEmployee
  Employee <|-- Admin
  Employee <|-- HRSpecialist
  Employee <|-- Manager
  OrganizationalUnit <|-- Department

  (ProjectEntity) : +start()
  (ProjectEntity) : +pause()
  (ProjectEntity) : +complete()
  (Employee) : +getRole()
  (Employee) : +performDuties()
  (Employee) : +getContactSummary()

---
Add this diagram to your report (or convert to PlantUML) if you need a graphical UML image.
