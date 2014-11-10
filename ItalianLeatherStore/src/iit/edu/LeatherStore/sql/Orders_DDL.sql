--------------------------------------------------------
--  File created - Sunday-March-30-2014   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table ORDERS
--------------------------------------------------------

  CREATE TABLE "SAGARIKAMRAJ"."ORDERS" 
   (	"ID" NUMBER, 
	"CUSTOMER_ID" NUMBER, 
	"ORDER_DATE" DATE, 
	"TOTAL_PRICE" NUMBER, 
	"STATUS" VARCHAR2(10 BYTE), 
	"SHIPPING_ADDRESS" VARCHAR2(255 BYTE), 
	"BILLING_ADDRESS" VARCHAR2(255 BYTE)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
REM INSERTING into SAGARIKAMRAJ.ORDERS
SET DEFINE OFF;
Insert into SAGARIKAMRAJ.ORDERS (ID,CUSTOMER_ID,ORDER_DATE,TOTAL_PRICE,STATUS,SHIPPING_ADDRESS,BILLING_ADDRESS) values (10,1,to_date('26-FEB-14','DD-MON-RR'),100,'IN STOCK','addr1','addr11');
Insert into SAGARIKAMRAJ.ORDERS (ID,CUSTOMER_ID,ORDER_DATE,TOTAL_PRICE,STATUS,SHIPPING_ADDRESS,BILLING_ADDRESS) values (20,2,to_date('27-FEB-14','DD-MON-RR'),200,'NO STOCK','addr2','addr22');
Insert into SAGARIKAMRAJ.ORDERS (ID,CUSTOMER_ID,ORDER_DATE,TOTAL_PRICE,STATUS,SHIPPING_ADDRESS,BILLING_ADDRESS) values (30,3,to_date('28-FEB-14','DD-MON-RR'),300,'SHIPPED','aaddr3','addr33');
--------------------------------------------------------
--  DDL for Index ORDER_ID
--------------------------------------------------------

  CREATE UNIQUE INDEX "SAGARIKAMRAJ"."ORDER_ID" ON "SAGARIKAMRAJ"."ORDERS" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table ORDERS
--------------------------------------------------------

  ALTER TABLE "SAGARIKAMRAJ"."ORDERS" ADD CONSTRAINT "ORDER_ID" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table ORDERS
--------------------------------------------------------

  ALTER TABLE "SAGARIKAMRAJ"."ORDERS" ADD CONSTRAINT "ORDERS_CUST_ID" FOREIGN KEY ("CUSTOMER_ID")
	  REFERENCES "SAGARIKAMRAJ"."CUSTOMERS" ("ID") ENABLE;
