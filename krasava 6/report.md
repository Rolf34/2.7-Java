Практична робота №6 — Застосування принципів поліморфізму в Java

Тема: Застосування поліморфізму та абстрактних класів

Титульний аркуш
- Назва дисципліни: Об'єктно-орієнтоване програмування
- Студент: [П.І.Б.]
- Група: [Номер групи]
- Викладач: [П.І.Б. викладача]
- Робота №6, дата: [дата]

Мета роботи
- Навчитись застосовувати принципи поліморфізму в Java: робити базові класи абстрактними, визначати абстрактні методи та взаємодіяти з об'єктами через абстрактні типи.

Короткий опис виконаних змін
- Перетворено `Employee` на абстрактний клас з трьома абстрактними методами: `getRole()`, `performDuties()`, `getContactSummary()`.
- Додано `RegularEmployee` — конкретну реалізацію `Employee` для використання фабрикою.
- Розширено `ProjectEntity` абстрактними методами життєвого циклу: `start()`, `pause()`, `complete()` (тепер всi проектні сутності реалізують ці методи).
- Оновлено `ObjectFactory` для створення `RegularEmployee` замість прямого створення `Employee`.
- Оновлено виклики/конструктори, щоб працювати з абстрактними типами (наприклад, `Project` тепер приймає `Employee` як власника).

Детальний перелік змінених файлів

**Класи Employee та підкласи:**
- `src/company/empoloyees/Employee.java` — став абстрактним, додано 3 абстрактні методи: `getRole()`, `performDuties()`, `getContactSummary()`
- `src/company/empoloyees/RegularEmployee.java` — НОВИЙ файл, конкретна реалізація `Employee`
- `src/company/empoloyees/Admin.java` — реалізовано нові абстрактні методи
- `src/company/empoloyees/HRSpecialist.java` — реалізовано нові абстрактні методи
- `src/company/empoloyees/Manager.java` — реалізовано нові абстрактні методи

**Класи ProjectEntity та підкласи:**
- `src/company/projects/ProjectEntity.java` — додано абстрактні lifecycle-методи: `start()`, `pause()`, `complete()`
- `src/company/projects/Project.java` — реалізовано lifecycle-методи з анотацією `@Override`, конструктор тепер приймає `Employee` (абстрактний тип)
- `src/company/projects/Task.java` — реалізовано lifecycle-методи з анотацією `@Override`

**Структура (Organization):**
- `src/company/structure/OrganizationalUnit.java` — вже був абстрактним; методи `activate()`, `deactivate()`, `getType()` забезпечують поліморфізм
- `src/company/structure/Department.java` — конкретна реалізація `OrganizationalUnit`

**Фабрика та сервіси:**
- `src/company/ObjectFactory.java` — оновлено для повернення `RegularEmployee`, метод `createProject()` приймає абстрактний `Employee`
- `src/main/Main.java` — адаптовано для створення `RegularEmployee`

**Документація та діаграми:**
- `docs/class-diagram.md` — опис структури абстрактних класів та методів
- `src/diagram_(html)/class_diagram_html.html` — інтерактивна mermaid-діаграма класів

Інструкція для збірки та запуску
1. Переконайтесь, що у вас встановлено JDK (версія 11 або новіша).
2. З кореня проекту виконайте в `cmd.exe` наступні команди:

```cmd
if exist filelist.txt del filelist.txt
for /R src %f in (*.java) do @echo %f >> filelist.txt
javac -d bin @filelist.txt
java -cp bin main.Main
```

3. Зробіть знімки екрану з консолі, коли програма виводить інформацію про департаменти, проекти та записи часу — ці знімки вставте у звіт.

Результати та спостереження
- Коли взаємодіяти з об'єктами через посилання на абстрактний тип (`Employee` або `ProjectEntity`), виклики абстрактних методів виконують реалізації підкласів — це демонструє динамічну диспетчеризацію (поліморфізм).
- Діаграма класів (`src/diagram_(html)/class_diagram_html.html`) показує ієрархію абстрактних класів:
  - `Employee` (абстрактний) з методами: `getRole()`, `performDuties()`, `getContactSummary()`
  - `ProjectEntity` (абстрактний) з методами: `start()`, `pause()`, `complete()`, `onStatusChanged()`
  - `OrganizationalUnit` (абстрактний) з методами: `activate()`, `deactivate()`, `getType()`
  - Всі конкретні підклаcи реалізують абстрактні методи та можуть передаватись як аргументи до функцій, що очікують батьківський абстрактний тип.

Скріншоти (приклади)
- [screenshot-1.png] — Вивід департаментів
- [screenshot-2.png] — Вивід статусів проєктів
- [screenshot-3.png] — Вивід запису робочого часу

Посилання на репозиторій
- Додайте тут URL на ваш GitHub-репозиторій після завантаження коду.
- Розглянути детальний список всіх змін: див. `CHANGES.md`

Пояснення для захисту
- Під час захисту покажіть модифікований клас-діаграму (`docs/class-diagram.md`) та запустіть `main.Main`, щоб продемонструвати роботу через абстрактні типи (наприклад, створення `RegularEmployee`, присвоєння до проекту та логування часу).

Примітка
- Для отримання PDF-звіту можна конвертувати цей Markdown (`report.md`) у PDF за допомогою будь-якого Markdown-редактора або `pandoc`.
