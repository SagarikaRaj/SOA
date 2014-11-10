drop table order_details;
drop table products;
drop table categories;
drop table maufacturers;
drop table orders;
drop table customers;

create table customers 
(
  id number
, name varchar2(255)
, address_line1 varchar2(255)
, address_line2 varchar2(255)
, state varchar2(2)
, zipcode number(5)
, phone varchar2(12)
, email varchar2(50)
, pssword varchar2(255)
, constraint cust_id primary key (id)
);

alter table customers add enroll_date date;

create table orders
(
  id number
, customer_id number
, order_date date
, total_price number
, status varchar2(10)
, shipping_address varchar2(255)
, billing_address varchar2(255)
, constraint order_id primary key (id)
, constraint orders_cust_id foreign key (customer_id) references customers(id)
);

create table maufacturers
(
  id number
, manufacturer_name  varchar2(255)
, image_location varchar2(255)
, description varchar2(255)
, title varchar2(255)
, constraint maufacturer_id primary key (id)
);

create table categories
(
  id number
, category_name varchar2(255)
, image_location varchar2(255)
, parent_id number
, constraint category_id primary key (id)
, constraint categories_parent_id  foreign key (parent_id) references categories(id)  
);

create table products
(
  id number
, category_id number
, manufacturer_id number
, name varchar2(255)
, description varchar2(255)
, price number
, quantity number
, model varchar2(255)
, title varchar2(255)
, weight number
, image_location varchar2(255)
, status varchar2(255)
, color varchar2(255)
, constraint product_id primary key (id)
, constraint product_category_id  foreign key (category_id) references categories(id)  
, constraint product_manufacturer_id  foreign key (manufacturer_id) references maufacturers(id)  
);

create table order_details
(
  id number
, order_id number
, product_id number
, price number
, quantity number
, constraint order_details_id primary key (id)
, constraint order_details_order_id  foreign key (order_id) references orders(id)  
, constraint order_details_product_id  foreign key (product_id) references products(id)  
);

