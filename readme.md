# Cakeshop Springboot Fullstack

| Project Title : **CakeShop** |
--------

### **Product Characteristics and Requirements:**

1. Secure MySQL database.
2. Token based authentication
3. different user roles and type.
4. login, logout, register etc.
5. Product listing and review System.
6. Easy to use and User intuitive Interface.

### **Project Management Deliverables:** <br />

Project plan, Research finding report, Work breakdown structure, Scope statement, Project charter, Training manuals, lessons learned report etc., **Product*related deliverables:**         Design documents, software code, project documentation and tips on its operation.,

## **Statement of Work**

1. Scope of Work

    This project is made as a university project for a person. It is an Ecommerce site based on **springboot framework** made to assist bakery shop owners in selling their products online. It has got role based user Authentication that also helps with **ERP**.

2. Acceptance Criteria:

    The acceptance criteria for the users are

    * The website has to communicate with the database.

    * Customer can easily login and register to the site

    * Owner can easily put their bakery listings.

    * The staffs and shop workers can easily be administered and managed.

    * Owner can easily manage the working and issues of Customer.

    * Maintaining the account details of the Customer.

    * Customer can view the available bakery items, and review the products available.

## **Project Design Document**

### **Introduction**

The project is based on two widely known frameworks, **Springboot** that is based on **Java**. For Database **MySQL** is used. The frameworks and the database used are based on industry standards and can be scaled via load balancers to handle heavy amounts of traffic resulting in less downtime leading to more profitability and good reputation in the market.

### **Purpose**

For frontend **Bootstrap** is used for design as it results in a very responsive site. It also helps the different components of a site to be developed independently giving a more independent work approach on the project resulting in higher customisability.

The backend is built up using **Springboot** as it is a Cross platform framework and being a java based makes the scalability of the site a breeze.

This project implements User login, logout, Dashboard for all types of users ranging from admin all the way to the customers, product listing and review system, various user intuitive features, and user register with a email verification support.

### **Scope**

This project is being developed for the customers who wish to buy bakery based products from the shop.

### **Intended Audience**

This document is intended for use by technical developers. This document also includes sections relevant to the operational and maintenance group.

* The intended audiences for this document are:
* The owner of this project.
* The team members of the company that is registered.
* The administrative staff of the company that this project is sold to.
* The future Developer that may work on the project

## **System Architecture: The Three Tier Architecture:**

To develop this project, the architecture that we are implementing is Three Tier Architecture. The Frontend, Backend and Data Storage Layer together called as Three Tier Architecture.

### **Frontend**

The Frontend is built up using **JSP** and **bootstrap** that has amazing features that makes user interaction and logic implementation a breeze . All the logics that require manipulation of data on client&#39;s side are handled here.

### **Backend**

The Backend is handled by **Springboot** that will give secured access to the database that is used. It also gives us the freedom to develop wide application logics on server side without compromising the security model of the project.

### **Data Storage Layer**

The Data Storage Layer will record all information required by the APIs developed in the backend. This data will include the details of the house/apartment, the general user and admin user information and much more. All passwords stored in the database will be encrypted to prevent unauthorized access. Within the Data Storage Layer, a collection of SQL Queries will provide access to the data in a meaningful way.

<br /><br /><br />

## **Database Description**

The Database for this project consists of 5*6 tables and can be deployed by importing the given sample dump in **MYSQL Workbench** or the desired MYSQL engine.

### Admin Panel Credentials

The admin panel can be accessed via following credentials.

Username: admin@gmail.com

Password: test

## **Project Requirements Specification**

### *Introduction*

#### **Purpose**

The main objective of this document is to illustrate the requirements of this project. The document gives the detailed description of the both functional and non*functional requirements of the project

#### **Document Conventions**

The following are the list of conventions and acronyms used in this document and the project as well:

* Administrator: A login id representing a user with user administration privileges to the software
* User: A general login id assigned to most users
* Client: Intended users for the software
* Frontend: The section of the assignment referring to what the user interacts with directly.
* Backend: The section of the assignment referring to the backend. This is where all computations are completed and server*side logics are written.
* Database: The section of the assignment referring to where all data is stored

#### **Intended Audience and Reading Suggestions**

The intended audiences for this document are:

* One who owns the project and is ready to deploy it in production

### **Overall Description**

#### **Product Perspective**

The **Cake Shop** is meant to help improve the bakery shop owners sale percentage by setting an onlinne footprint. It helps the Customers buy the products online.

#### **Product Features**

There are two different users who will be using this product:

* Owners, shop workers and the staffs that will use this project to manage shop

* Customers who will be accessing the website.

#### **User Documentation**

The product will include user manual. The user manual will include product overview, complete configuration of the used software (such as SQL server), technical details, backup procedure and contact information which will include email address. The product will be compatible with all the modern browsers present. The databases will be created in the MySQL.

#### Assumptions and Dependencies

The product needs following third party product.

* Online MySQL server to store the database.

* Shared hosting that supports **Springboot** or a secured VPS on which Backend and database server will be deployed

### **Non Functional Requirements**

#### **Hardware Interfaces**

**Server Side:**

* Operating System: Ubuntu or windows*based VPS.

* Processor: 2 or more vcpus.

* RAM: 2048 Mb or more

* Hard Drive: 500 GB or more

#### **Client side:**

* Operating System: Windows xp or above, MAC or LINUX.

* Processor: Pentium III or 2.0 GHz or higher.

* RAM: 256 Mb or more

* Modern Browser( Safari, Chrome or Firefox) .

#### **Communications Interfaces**

The Customer must connect to the Internet to access the Website:

* Dialup Modem of 52 kbps

* Broadband Internet

* Dialup or Broadband Connection with an Internet Provider.
