DROP TABLE IF EXISTS department;
DROP TABLE IF EXISTS salary;
DROP TABLE IF EXISTS branch;
DROP TABLE IF EXISTS job;
DROP TABLE IF EXISTS employees;

CREATE TABLE employees (
  employee_pk int unsigned NOT NULL AUTO_INCREMENT,
  employee_id varchar(40) NOT NULL,
  last_name varchar(40) NOT NULL,
  first_name enum('JIM', 'PAM', 'STANLEY', 'RYAN', 'MICHAEL', 'DWIGHT') NOT NULL, 
  PRIMARY KEY (employee_pk)
);

CREATE TABLE job (
  job_pk int unsigned NOT NULL AUTO_INCREMENT,
  job_id enum('RECEPTIONIST', 'SALESMAN', 'ACCOUNTING', 'CUSTOMER_SERVICE', 'MANAGER') NOT NULL, 
  job_title varchar(40) NOT NULL,
  employee_fk int unsigned,
  first_name varchar(40) NOT NULL,
  PRIMARY KEY (job_pk),
  UNIQUE KEY (job_id, first_name),
  FOREIGN KEY (employee_fk) REFERENCES employees (employee_pk) ON DELETE CASCADE
);

CREATE TABLE branch (
  branch_pk int unsigned NOT NULL AUTO_INCREMENT,
  branch_id varchar(40) NOT NULL,
  new_branch varchar(40),
  branch_name enum('SCRANTON', 'NEWYORK', 'AKRON', 'SYRACUSE', 'UTICA', 'NASHUA') NOT NULL,
  PRIMARY KEY (branch_pk)
  );
  
 CREATE TABLE salary (
  salary_pk int unsigned NOT NULL AUTO_INCREMENT,
  salary_id varchar(40),
  yrSalary enum('FORTY_THOUSAND','FIFTY_THOUSAND','SIXTY_THOUSAND','SEVENTY_THOUSAND','EIGHTY_THOUSAND') NOT NULL,
  PRIMARY KEY (salary_pk),
  UNIQUE KEY (salary_id)
);

CREATE TABLE department (
  department_pk int unsigned NOT NULL AUTO_INCREMENT,
  department_id varchar(45),
  dept_name varchar(45) NOT NULL,
  PRIMARY KEY (department_pk),
  UNIQUE KEY (dept_name)
); 