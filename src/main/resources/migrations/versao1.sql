-- Database generated with pgModeler (PostgreSQL Database Modeler).
-- pgModeler version: 0.9.4
-- PostgreSQL version: 13.0
-- Project Site: pgmodeler.io
-- Model Author: ---

-- Database creation must be performed outside a multi lined SQL file. 
-- These commands were put in this file only as a convenience.
-- 
-- object: novo_banco_de_dados | type: DATABASE --
-- DROP DATABASE IF EXISTS novo_banco_de_dados;
CREATE DATABASE novo_banco_de_dados;
-- ddl-end --


-- object: public."Usuario" | type: TABLE --
-- DROP TABLE IF EXISTS public."Usuario" CASCADE;
CREATE TABLE public."Usuario" (
	"Id" serial NOT NULL,
	"Nome" text,
	email text,
	CONSTRAINT "Usuario_pk" PRIMARY KEY ("Id")
);
-- ddl-end --
ALTER TABLE public."Usuario" OWNER TO postgres;
-- ddl-end --

-- object: public."Notas" | type: TABLE --
-- DROP TABLE IF EXISTS public."Notas" CASCADE;
CREATE TABLE public."Notas" (
	"Titulo" text,
	"Corpo" text,
	"Id_Notas" serial NOT NULL,
	"Id_Usuario" integer,
	CONSTRAINT "Notas_pk" PRIMARY KEY ("Id_Notas")
);
-- ddl-end --
ALTER TABLE public."Notas" OWNER TO postgres;
-- ddl-end --

-- object: public."Categoria" | type: TABLE --
-- DROP TABLE IF EXISTS public."Categoria" CASCADE;
CREATE TABLE public."Categoria" (
	"Nome_Categoria" text,
	"Id_categorias" serial NOT NULL,
	CONSTRAINT "Categoria_pk" PRIMARY KEY ("Id_categorias")
);
-- ddl-end --
ALTER TABLE public."Categoria" OWNER TO postgres;
-- ddl-end --

-- object: "Usuario_fk" | type: CONSTRAINT --
-- ALTER TABLE public."Notas" DROP CONSTRAINT IF EXISTS "Usuario_fk" CASCADE;
ALTER TABLE public."Notas" ADD CONSTRAINT "Usuario_fk" FOREIGN KEY ("Id_Usuario")
REFERENCES public."Usuario" ("Id") MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: "Notas_uq" | type: CONSTRAINT --
-- ALTER TABLE public."Notas" DROP CONSTRAINT IF EXISTS "Notas_uq" CASCADE;
ALTER TABLE public."Notas" ADD CONSTRAINT "Notas_uq" UNIQUE ("Id_Usuario");
-- ddl-end --

-- object: public."Notas_Categoria" | type: TABLE --
-- DROP TABLE IF EXISTS public."Notas_Categoria" CASCADE;
CREATE TABLE public."Notas_Categoria" (
	"Id_Notas_Notas" integer,
	"Id_categorias_Categoria" integer

);
-- ddl-end --
ALTER TABLE public."Notas_Categoria" OWNER TO postgres;
-- ddl-end --

-- object: "Notas_fk" | type: CONSTRAINT --
-- ALTER TABLE public."Notas_Categoria" DROP CONSTRAINT IF EXISTS "Notas_fk" CASCADE;
ALTER TABLE public."Notas_Categoria" ADD CONSTRAINT "Notas_fk" FOREIGN KEY ("Id_Notas_Notas")
REFERENCES public."Notas" ("Id_Notas") MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: "Categoria_fk" | type: CONSTRAINT --
-- ALTER TABLE public."Notas_Categoria" DROP CONSTRAINT IF EXISTS "Categoria_fk" CASCADE;
ALTER TABLE public."Notas_Categoria" ADD CONSTRAINT "Categoria_fk" FOREIGN KEY ("Id_categorias_Categoria")
REFERENCES public."Categoria" ("Id_categorias") MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --


