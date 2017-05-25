-- Table: public.users

-- DROP TABLE public.users;

CREATE TABLE public.users
(

  email character(255) NOT NULL,
  name character(255) NOT NULL,
  password character(255) NOT NULL,
  CONSTRAINT users_pkey PRIMARY KEY (email)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.users
  OWNER TO postgres;