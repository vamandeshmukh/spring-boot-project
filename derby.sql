CREATE TABLE departments(
department_id INTEGER PRIMARY KEY, 
name VARCHAR(50), 
location VARCHAR(50));

CREATE TABLE employees(
employee_id INTEGER PRIMARY KEY, 
name VARCHAR(50), 
salary DOUBLE, 
department_id INTEGER REFERENCES departments(department_id));

INSERT INTO departments(department_id, name, location) VALUES(10, 'HR', 'Hyderabad');
INSERT INTO departments(department_id, name, location) VALUES(20, 'IT', 'Chennai');
INSERT INTO departments(department_id, name, location) VALUES(30, 'Marketing', 'Bengaluru');
INSERT INTO departments(department_id, name, location) VALUES(40, 'Admin', 'Pune');

commit;

INSERT INTO employees(employee_id, name, salary, department_id) VALUES(1001, 'Sonu', 10.5, 10);
INSERT INTO employees(employee_id, name, salary, department_id) VALUES(1002, 'Monu', 15.6, 10);
INSERT INTO employees(employee_id, name, salary, department_id) VALUES(1003, 'Tonu', 12.2, 20);
INSERT INTO employees(employee_id, name, salary, department_id) VALUES(1004, 'Ponu', 20.8, 30);
INSERT INTO employees(employee_id, name, salary, department_id) VALUES(1005, 'Gonu', 22.4, NULL);
INSERT INTO employees(employee_id, name, salary, department_id) VALUES(1006, 'Donu', 45.50, 20);

commit;
