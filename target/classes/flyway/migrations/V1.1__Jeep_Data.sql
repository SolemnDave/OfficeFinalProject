-- employees
INSERT INTO EMPLOYEES (employee_id, last_name, first_name) VALUES ('JH', 'halpert', 'jim');
INSERT INTO EMPLOYEES (employee_id, last_name, first_name) VALUES ('PM', 'beesly', 'pam');
INSERT INTO EMPLOYEES (employee_id, last_name, first_name) VALUES ('SM', 'manly', 'stanley');
INSERT INTO EMPLOYEES (employee_id, last_name, first_name) VALUES ('RH', 'howard', 'ryan');
INSERT INTO EMPLOYEES (employee_id, last_name, first_name) VALUES ('MS', 'scotch', 'michael');
INSERT INTO EMPLOYEES (employee_id, last_name, first_name) VALUES ('DS', 'shrute', 'dwight');

-- job
INSERT INTO JOB (job_title, job_id, first_name) VALUES ('RC', 'RECEPTIONIST', 'pam');
INSERT INTO JOB (job_title, job_id, first_name) VALUES ('SM', 'SALESMAN', 'jim');
INSERT INTO JOB (job_title, job_id, first_name) VALUES ('AC', 'ACCOUNTING', 'kevin');
INSERT INTO JOB (job_title, job_id, first_name) VALUES ('CS', 'CUSTOMER_SERVICE', 'kelly');
INSERT INTO JOB (job_title, job_id, first_name) VALUES ('RM', 'MANAGER', 'michael');

-- branch
INSERT INTO BRANCH (branch_id, branch_name) VALUES ('NY', 'NEWYORK');
INSERT INTO BRANCH (branch_id, branch_name) VALUES ('NY', 'SYRACUSE');
INSERT INTO BRANCH (branch_id, branch_name) VALUES ('NY', 'UTICA');
INSERT INTO BRANCH (branch_id, branch_name) VALUES ('NH', 'NASHUA');
INSERT INTO BRANCH (branch_id, branch_name) VALUES ('PA', 'SCRANTON');
INSERT INTO BRANCH (branch_id, branch_name) VALUES ('OH', 'AKRON');

-- salary
INSERT INTO SALARY (yrSalary) VALUES ('FORTY_THOUSAND');
INSERT INTO SALARY (yrSalary) VALUES ('FORTY_THOUSAND');
INSERT INTO SALARY (yrSalary) VALUES ('SIXTY_THOUSAND');
INSERT INTO SALARY (yrSalary) VALUES ('EIGHTY_THOUSAND');
INSERT INTO SALARY (yrSalary) VALUES ('SIXTY_THOUSAND');
INSERT INTO SALARY (yrSalary) VALUES ('FIFTY_THOUSAND');
INSERT INTO SALARY (yrSalary) VALUES ('SEVENTY_THOUSAND');
INSERT INTO SALARY (yrSalary) VALUES ('FIFTY_THOUSAND');
INSERT INTO SALARY (yrSalary) VALUES ('FORTY_THOUSAND');

-- departments
INSERT INTO DEPARTMENT (dept_name) VALUES ('Accounting');
INSERT INTO DEPARTMENT (dept_name) VALUES ('Customer Service');
INSERT INTO DEPARTMENT (dept_name) VALUES ('Human Resources');
INSERT INTO DEPARTMENT (dept_name) VALUES ('Management');
INSERT INTO DEPARTMENT (dept_name) VALUES ('Reception');
INSERT INTO DEPARTMENT (dept_name) VALUES ('Sales');