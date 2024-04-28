USE master;
GO

IF EXISTS (SELECT name FROM sys.databases WHERE name = N'udemybookdb')
    DROP DATABASE udemybookdb;
GO

IF EXISTS (SELECT name FROM sys.server_principals WHERE name = N'bookadmin')
    DROP LOGIN bookadmin;
GO

IF EXISTS (SELECT name FROM sys.server_principals WHERE name = N'bookuser')
    DROP LOGIN bookuser;
GO

CREATE DATABASE udemybookdb;
GO

CREATE LOGIN bookadmin WITH PASSWORD = 'admin123';
GO

CREATE LOGIN bookuser WITH PASSWORD = 'user123';
GO

USE bookdb;
GO

CREATE USER bookadmin FOR LOGIN bookadmin;
CREATE USER bookuser FOR LOGIN bookuser;
GO

ALTER ROLE db_owner ADD MEMBER bookadmin;
ALTER ROLE db_datareader ADD MEMBER bookuser;
ALTER ROLE db_datawriter ADD MEMBER bookuser;
GO
