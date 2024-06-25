CREATE DATABASE bookdb WITH ENCODING 'UTF8';
-- Create the admin user
CREATE USER super_user WITH PASSWORD 'admin123';
-- Create the limited user
CREATE USER just_user WITH PASSWORD 'limited123';
-- Grant all privileges on the database to the admin user
GRANT ALL PRIVILEGES ON DATABASE bookdb TO super_user;
-- Grant usage on the schema
GRANT USAGE ON SCHEMA public TO just_user;

-- Grant select, insert, update, and delete on all tables in the schema to the limited user
GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA public TO just_user;

-- Ensure the limited user can access future tables
ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT SELECT, INSERT, UPDATE, DELETE ON TABLES TO just_user;
