ASSIGNMENT

Java Spring Boot project to detect duplicate characters in a list.
The project implements two algorithms:

- O(n): uses a HashSet to check for duplicates in linear time.
- O(n log n): sorts the list and compares adjacent elements.

---

Requirements

- Java 17+
- Maven 3.8+
- Git ...

---

How to run the project

1. Clone the repository:
   git clone <YOUR_REPOSITORY_URL>
   cd ASSIGNMENT

2. Build the project:
   mvn clean install

3. Run the Spring Boot application:
   mvn spring-boot:run

---

Example output

When the application runs, you should see something like:

O(n) result: true, time(ns): 14250
O(n log n) result: true, time(ns): 99910291

---

Execution Time Comparison

Algorithm      Duplicates Found   Time (ns)     Time (ms)    Time (s)
O(n)           true               14,250        0.01425      0.00001425
O(n log n)     true               99,910,291    99.910       0.09991

> The table shows execution times in nanoseconds, milliseconds, and seconds for easy comparison.

---

Code Formatting with Spotless

To format your code automatically using the Spotless Maven plugin:

Apply formatting:
mvn spotless:apply

Check formatting without applying changes:
mvn spotless:check