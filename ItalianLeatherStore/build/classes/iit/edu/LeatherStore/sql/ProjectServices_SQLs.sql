--List All new customers giving a date (Service API  getCustomers(Date date))
select name
,      NVL(state,'No State')
,      NVL(zipcode,0)
,      NVL(phone,0)
,      NVL(enroll_date,'')
from   customers
where  enroll_date > '02-MAR-2010'; --replace this by given input


--List all new Orders giving a month/year (Service API  getOrders(int month, int year))
select o.id as orderId
,      o.order_date as OrderDate
,      o.total_price as OrderPrice
,      o.status as OrderStatus
from orders o
where to_char(order_date,'MM') = 2 --replace this by input value
and   extract(year from order_date) = 2014; --replace this by input value


--List Products Inventory (Service API  getInventory())
select p.name as product
,      p.description as prodDesc
,      p.price as price
,      p.model as productModel
,      p.title as title
,      p.weight as weight
,      p.status as status
,      p.color as color
,      ca.category_name as category
,      m.MANUFACTURER_NAME as manufacturer
from products p
,    categories ca
,    maufacturers m
where p.category_id = ca.id
and   p.manufacturer_id = m.id;

--List customers and their ordered products for a given year (Service API getCustomerProdcuts(int year))
select c.name as customer
,      o.order_date as OrderDate
,      o.total_price as OrderPrice
,      o.status as OrderStatus
from customers c
,    orders o
where o.customer_id = c.id 
and   extract(year from order_date) = 2014; --replace this by input value

--List all orders that are not shipped yet (status != Shipped) (Service API getNotFulfilled ())  
select o.id as orderID
,      o.order_date as OrderDate
,      o.total_price as OrderPrice
,      o.status as OrderStatus
from orders o    
where o.status != 'SHIPPED';


