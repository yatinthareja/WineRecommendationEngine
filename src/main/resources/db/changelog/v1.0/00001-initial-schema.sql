CREATE TABLE restaurant (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    "uuid" UUID NOT NULL,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(1023),
    address VARCHAR(255) NOT NULL,
    phone_number VARCHAR(20),
    email VARCHAR(255) NOT NULL,
    created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
	created_by varchar(255) NOT NULL,
	modified_at timestamp NULL,
	modified_by varchar(255) NULL
);
CREATE INDEX restaurant_uuid_idx ON public.restaurant USING btree ("uuid");

CREATE TABLE "table" (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    "uuid" UUID NOT NULL,
    restaurant_id int8 not null,
    table_number VARCHAR(20) NOT NULL,
    capacity int NOT NULL,
    created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
	created_by varchar(255) NOT NULL,
	modified_at timestamp NULL,
	modified_by varchar(255) NULL,
    CONSTRAINT table_restaurant_id_fk FOREIGN KEY (restaurant_id) REFERENCES public.restaurant(id)
);
CREATE INDEX table_uuid_idx ON public."table" USING btree ("uuid");

CREATE TABLE guest (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    "uuid" UUID NOT NULL,
    salutation VARCHAR(5),
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email_address VARCHAR(320) NOT NULL,
    phone_number BIGINT,
    phone_number_verified BOOLEAN DEFAULT FALSE,
    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    create_by VARCHAR(255),
    modified_date TIMESTAMP,
    modified_by VARCHAR(255)
);
CREATE INDEX guest_uuid_idx ON public.guest USING btree ("uuid");

CREATE TABLE "user" (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    "uuid" UUID NOT NULL,
    salutation VARCHAR(5),
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email_address VARCHAR(320) NOT NULL UNIQUE,
    phone_number BIGINT,
    phone_number_verified BOOLEAN DEFAULT FALSE,
    password_hash VARCHAR(255) NOT NULL,
    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(255),
    modified_date TIMESTAMP,
    modified_by VARCHAR(255),
    is_active BOOLEAN DEFAULT TRUE
);
CREATE INDEX user_uuid_idx ON public."user" USING btree ("uuid");

CREATE TABLE reservation (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    "uuid" UUID NOT NULL,
    user_id BIGINT,
    guest_id BIGINT,
    message TEXT,
    promotion_code VARCHAR(20),
    restaurant_id BIGINT,
    table_id BIGINT,
    reservation_date DATE,
    reservation_time TIME,
    number_of_guests INT,
    status VARCHAR(20),
    create_date TIMESTAMP,
    create_by VARCHAR(255),
    modified_date TIMESTAMP,
    modified_by VARCHAR(255),
    CONSTRAINT user_id_reservation_fk FOREIGN KEY (user_id) REFERENCES public."user"(id),
    CONSTRAINT guest_id_reservation_fk FOREIGN KEY (guest_id) REFERENCES public.guest(id),
    CONSTRAINT restaurant_id_reservation_fk FOREIGN KEY (restaurant_id) REFERENCES public.restaurant(id)
);
CREATE INDEX reservations_uuid_idx ON public.reservation USING btree ("uuid");