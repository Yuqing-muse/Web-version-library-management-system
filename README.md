# Web-version-library-management-system
**Development Platform Overview**

Implemented in java, JavaScripts, XML and MySQL.

This system uses a B-S architecture. The chosen backend database is MySQL.
The software development platform is MyEclipse as well as MySQL.
Its software runtime platform is apache-tomcat-7.0.81-windows-x64

# Features
**Administrator**

The administrator is responsible for the loan and return operations of the book circulation process. It also includes.
1. Book management: basic operations such as modification, enquiry and deletion of book information.
2. Reader management: including the addition, query, modification and deletion of reader information.
3. Enquiry of bad records
4. Book borrowing and returning operation: you need to input reader ID number and book number, and then judge whether the current reader has bad record and whether you can borrow and return books.
5. View and process the reader's request information.
6. Query the current number of books in the library.
7. Query the reader's bad record.

**User**
1. Check all borrowing records and current borrowing books.
2. Change personal information, password, etc.
3. Search for books according to author, book number, etc.
4. Renew borrowed books.

# Security Mechanisms
I've implemented two types of security mechanisms in this library management system: system security and data security.
Access to the system as a visitor is not permitted for system security reasons. All users must sign up or log in. Login will validate the username and password, and the system will only be accessible if the two match.
Access to and use of database objects is strictly controlled in terms of data security, with certain tables only accessible with specific permissions.

# Demo
# Login or sign up
Register as new reader:
![1](https://user-images.githubusercontent.com/62585203/131786264-57c465dd-6cde-4fb3-904e-7fbe8ea06d69.jpg)
Choose to log in as administrator:
![2](https://user-images.githubusercontent.com/62585203/131786293-52485e51-fa31-46fa-9b1e-97eb7d0ac4a6.jpg)

# Users Features
If the user is successfully registered, they will be automatically redirected to the reader page without having to log in again. If the registered reader username and password match, they will also be redirected.
**Search books**
![3](https://user-images.githubusercontent.com/62585203/131787020-325d3670-5f29-41ed-b7b8-1913bdfbe593.png)

**Borrow History**
![4](https://user-images.githubusercontent.com/62585203/131787075-b594edeb-7020-442c-bb89-0d7f38dbdc7d.png)
**Payments for expired books**

![5](https://user-images.githubusercontent.com/62585203/131787139-fed13ae4-31f8-43b6-895b-fcfed4bee604.png)

# Administrator Features
Log in as an administrator
![1](https://user-images.githubusercontent.com/62585203/131787269-dce63aca-cb2d-469e-8661-26ca34cbe2c1.jpg)
The administrator can view the list of books in the library. The books are first sorted by branch and the administrator can enter new books.
![2](https://user-images.githubusercontent.com/62585203/131787340-52440c73-2b1c-439b-8083-1ede46ff46c0.jpg)
The administrator can check the borrowing status of the readers.
![3](https://user-images.githubusercontent.com/62585203/131787382-b785f165-34b3-492f-aaec-f3c141de0271.png)


