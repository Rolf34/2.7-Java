# Практична робота №6 — Список змін (Polymorphism Implementation)

## Резюме
Реалізовано принципи поліморфізму у Java-проекті: перетворено базові класи на абстрактні, додано абстрактні методи, та оновлено всі взаємодії для роботи з абстрактними типами замість конкретних реалізацій.

## Змінені файли

### 1. **Employee Hierarchy** (Поліморфізм на рівні співробітників)

#### `src/company/empoloyees/Employee.java`
- **Змінено:** Клас став `abstract`
- **Додано:** 3 абстрактні методи:
  - `public abstract String getRole()`
  - `public abstract void performDuties()`
  - `public abstract String getContactSummary()`
- **Обґрунтування:** Демонструє поліморфний доступ до різних типів співробітників через базовий тип

#### `src/company/empoloyees/RegularEmployee.java` (НОВИЙ ФАЙЛ)
- **Назначение:** Конкретна реалізація `Employee` для стандартних працівників
- **Реалізовано:** Всі три абстрактні методи
- **Використання:** Використовується `ObjectFactory.createEmployee()`

#### `src/company/empoloyees/Admin.java`
- **Додано:** Реалізація трьох абстрактних методів з `Employee`
- **Поведінка:** `getRole()` повертає "Admin", `performDuties()` виконує адміністративні завдання

#### `src/company/empoloyees/HRSpecialist.java`
- **Додано:** Реалізація трьох абстрактних методів
- **Поведінка:** `getRole()` повертає "HR Specialist", методи орієнтовані на HR-функції

#### `src/company/empoloyees/Manager.java`
- **Додано:** Реалізація трьох абстрактних методів
- **Поведінка:** `getRole()` повертає "Manager", `performDuties()` орієнтовано на управління відділом

---

### 2. **ProjectEntity Hierarchy** (Поліморфізм на рівні проектних сутностей)

#### `src/company/projects/ProjectEntity.java`
- **Змінено:** Клас залишається `abstract`
- **Додано:** 3 абстрактні методи життєвого циклу:
  - `public abstract void start()`
  - `public abstract void pause()`
  - `public abstract void complete()`
- **Збережено:** `protected abstract void onStatusChanged()`
- **Обґрунтування:** Всі проектні сутності повинні мати єдиний інтерфейс управління циклом життя

#### `src/company/projects/Project.java`
- **Додано:** `@Override` анотація для трьох методів (`start()`, `pause()`, `complete()`)
- **Змінено:** Конструктор тепер приймає `Employee` (абстрактний тип) замість `Manager` — це ключова демонстрація поліморфізму
- **Поведінка:** Кожен метод цикл життя безпосередньо викликає відповідну внутрішню операцію

#### `src/company/projects/Task.java`
- **Додано:** `@Override` анотація для трьох методів (`start()`, `pause()`, `complete()`)
- **Поведінка:** Аналогічна `Project`, але з урахуванням залежності від батьківського проекту

---

### 3. **OrganizationalUnit Hierarchy** (Поліморфізм на рівні організаційної структури)

#### `src/company/structure/OrganizationalUnit.java`
- **Статус:** Вже був `abstract`
- **Абстрактні методи:** `activate()`, `deactivate()`, `getType()` — визначають поліморфну поведінку

#### `src/company/structure/Department.java`
- **Реалізація:** Конкретна реалізація методів з `OrganizationalUnit`
- **Спадкування:** Успадковує від `OrganizationalUnit`, поводиться як конкретна організаційна одиниця

---

### 4. **Factory & Services** (Поліморфна фабрика)

#### `src/company/ObjectFactory.java`
- **Змінено:** Метод `createEmployee()` тепер повертає `RegularEmployee` (конкретна реалізація) замість абстрактного `Employee`
- **Змінено:** Метод `createProject()` тепер приймає абстрактний `Employee` як owner, не конкретний `Manager`
- **Обґрунтування:** Фабрика демонструє, як працювати з абстрактними типами в повсякденному коді

#### `src/main/Main.java`
- **Змінено:** Методи `createDeveloper()` тепер створюють `RegularEmployee`
- **Адаптовано:** Коди, що використовували прямо `new Employee()`, тепер використовують `RegularEmployee` або фабрику

---

### 5. **Documentation & Diagrams** (Документація та діаграми)

#### `docs/class-diagram.md`
- **Додано:** Опис класів-діаграми з перелічуванням абстрактних методів
- **Включено:** UML-подібна схема та пояснення поліморфних взаємодій

#### `src/diagram_(html)/class_diagram_html.html`
- **Оновлено:** Інтерактивна mermaid-діаграма, що показує:
  - Абстрактні класи (`Employee`, `ProjectEntity`, `OrganizationalUnit`)
  - Всі абстрактні методи (з позначенням `*`)
  - Конкретні реалізації (`RegularEmployee`, `Admin`, `Manager`, `HRSpecialist`, `Project`, `Task`, `Department`)
  - Асоціації та спадкування

#### `report.md`
- **Оновлено:** Додано детальний перелік змінених файлів та обґрунтування

---

## Ключові принципи поліморфізму, що були реалізовані

1. **Абстрактні класи як контракти:** Всі базові класи (`Employee`, `ProjectEntity`, `OrganizationalUnit`) визначають контракт для своїх реалізацій.

2. **Поліморфна діспетчеризація:** Коли код посилається на об'єкт через абстрактний тип, виклик методу розв'язується до конкретної реалізації на основі типу об'єкта.

3. **Заміна конкретних типів на абстрактні:** Функції та конструктори тепер приймають абстрактні типи (наприклад, `Employee`, `ProjectEntity`) замість конкретних (`Manager`, `Project`).

4. **Factory Pattern із поліморфізмом:** `ObjectFactory` демонструє, як фабрика повертає конкретні реалізації, але обробляються вони як абстрактні типи.

---

## Перевірка

Щоб перевірити роботу:

```bash
# Збір проекту
cd "c:\Users\Home\Desktop\ea_projects\krasava 6"
if exist filelist.txt del filelist.txt
for /R src %f in (*.java) do @echo %f >> filelist.txt
javac -d bin @filelist.txt

# Запуск
java -cp bin main.Main
```

**Очікуваний результат:** Програма повинна:
- Створити різні типи співробітників через `RegularEmployee`, `Manager`, `Admin`, `HRSpecialist`
- Створити проект з власником типу `Employee` (поліморфне прив'язування)
- Вивести інформацію про департаменти, проекти та записи часу без помилок

---

## Список файлів для GitHub commit

```
src/company/empoloyees/Employee.java
src/company/empoloyees/RegularEmployee.java
src/company/empoloyees/Admin.java
src/company/empoloyees/HRSpecialist.java
src/company/empoloyees/Manager.java
src/company/projects/ProjectEntity.java
src/company/projects/Project.java
src/company/projects/Task.java
src/company/structure/OrganizationalUnit.java
src/company/structure/Department.java
src/company/ObjectFactory.java
src/main/Main.java
docs/class-diagram.md
src/diagram_(html)/class_diagram_html.html
report.md
CHANGES.md
```

---

## Commit Message (рекомендується)

```
feat: implement polymorphism principles for practical work #6

- Make Employee abstract with 3 abstract methods (getRole, performDuties, getContactSummary)
- Add RegularEmployee concrete class for factory
- Make ProjectEntity lifecycle methods abstract (start, pause, complete)
- Update Project/Task to implement lifecycle methods with @Override
- Refactor Project constructor to accept abstract Employee type for owner
- Update ObjectFactory to use RegularEmployee and abstract Employee parameter
- Add RegularEmployee implementation to all employee subclasses
- Update class diagram HTML with abstract classes and methods visualization
- Add detailed change list and documentation

This implements key polymorphism patterns:
- Abstract classes as contracts
- Polymorphic dispatch through abstract types
- Replacement of concrete types with abstract types in function signatures
- Factory pattern with polymorphism
```
