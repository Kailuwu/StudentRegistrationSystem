Code Review Findings - StudentRegistration.java
Reviewer: retrospect123
Total Issues: 10

1. Unclear Parameter Names (Naming Conventions)
   - Issue: Single-letter parameters (n, a, g) in add() are hard to read.
   - Fix: Rename them to name, age, and grade.

2. Unclear Loop Variable (Naming Conventions)
   - Issue: s in "for (String s : students)" is too vague.
   - Fix: Rename s to student.

3. Age and Grade Are Not Saved (Logical Error)
   - Issue: students.add(n) only saves the name, so age and grade are lost in display().
   - Fix: Create a Student class to store name, age, and grade together.

4. Allows Duplicate Students (Logical Error)
   - Issue: Calling add("John", 20, 85) twice adds the same student twice.
   - Fix: Check if the student's name already exists before adding.

5. No Name Validation (Input Validation)
   - Issue: Empty names like "" are accepted.
   - Fix: Reject empty or blank names.

6. No Age Validation (Input Validation)
   - Issue: Negative ages like -5 are accepted.
   - Fix: Only allow valid ages (5 to 120).

7. No Grade Validation (Input Validation)
   - Issue: Grades over 100 (like 150) or below 0 are accepted.
   - Fix: Only allow grades between 0 and 100.

8. No Null Check (Exception Handling)
    - Issue: Passing null as a name will crash the program with a NullPointerException.
    - Fix: Check if name is null before processing it.

9. Repeated Print Statements (Duplicate Code)
    - Issue: Four separate System.out.println lines are used to print one student's info.
    - Fix: Use a toString() method in a Student class to format the output once.

10. Unprotected List and Mixed Logic (Security and Maintainability)
    - Issue: students is not private (other classes can edit it directly) and printing is mixed inside add().
    - Fix: Make students private and return true/false from addStudent().