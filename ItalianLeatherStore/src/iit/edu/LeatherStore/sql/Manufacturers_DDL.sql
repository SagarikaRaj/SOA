--------------------------------------------------------
--  File created - Sunday-March-30-2014   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table MAUFACTURERS
--------------------------------------------------------

  CREATE TABLE "SAGARIKAMRAJ"."MAUFACTURERS" 
   (	"ID" NUMBER, 
	"MANUFACTURER_NAME" VARCHAR2(255 BYTE), 
	"IMAGE_LOCATION" VARCHAR2(255 BYTE), 
	"DESCRIPTION" VARCHAR2(255 BYTE), 
	"TITLE" VARCHAR2(255 BYTE)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
REM INSERTING into SAGARIKAMRAJ.MAUFACTURERS
SET DEFINE OFF;
Insert into SAGARIKAMRAJ.MAUFACTURERS (ID,MANUFACTURER_NAME,IMAGE_LOCATION,DESCRIPTION,TITLE) values (100,'Manufacturer1','D://','ManuDesc1','Title1');
Insert into SAGARIKAMRAJ.MAUFACTURERS (ID,MANUFACTURER_NAME,IMAGE_LOCATION,DESCRIPTION,TITLE) values (200,'Manufacturer2','C://','ManuDesc2','Title2');
Insert into SAGARIKAMRAJ.MAUFACTURERS (ID,MANUFACTURER_NAME,IMAGE_LOCATION,DESCRIPTION,TITLE) values (300,'Manufacturer3','E://','MenuDesc3','Title3');
--------------------------------------------------------
--  DDL for Index MAUFACTURER_ID
--------------------------------------------------------

  CREATE UNIQUE INDEX "SAGARIKAMRAJ"."MAUFACTURER_ID" ON "SAGARIKAMRAJ"."MAUFACTURERS" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table MAUFACTURERS
--------------------------------------------------------

  ALTER TABLE "SAGARIKAMRAJ"."MAUFACTURERS" ADD CONSTRAINT "MAUFACTURER_ID" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE;
