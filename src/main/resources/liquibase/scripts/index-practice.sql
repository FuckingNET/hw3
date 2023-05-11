-- liquibase formatted sql

-- changeset amusaev:1
CREATE INDEX name_student_index ON student (name);

CREATE INDEX faculty_nc_index ON faculty (name, color);
