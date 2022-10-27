
CREATE TABLE public."usuario" (
	"id" serial NOT NULL,
	"nome" text,
	email text,
	CONSTRAINT "usuario_pk" PRIMARY KEY ("id")
);
-- ddl-end --
ALTER TABLE public."usuario" OWNER TO postgres;
-- ddl-end --

-- object: public."Notas" | type: TABLE --
-- DROP TABLE IF EXISTS public."Notas" CASCADE;
CREATE TABLE public."notas" (
	"titulo" text,
	"corpo" text,
	"id" serial NOT NULL,
	"id_usuario" integer,
	CONSTRAINT "notas_pk" PRIMARY KEY ("id")
);
-- ddl-end --
ALTER TABLE public."notas" OWNER TO postgres;
-- ddl-end --

-- object: public."Categoria" | type: TABLE --
-- DROP TABLE IF EXISTS public."Categoria" CASCADE;
CREATE TABLE public."categoria" (
	"nome" text,
	"id" serial NOT NULL,
	CONSTRAINT "categoria_pk" PRIMARY KEY ("id")
);
-- ddl-end --
ALTER TABLE public."categoria" OWNER TO postgres;
-- ddl-end --

-- object: "Usuario_fk" | type: CONSTRAINT --
-- ALTER TABLE public."Notas" DROP CONSTRAINT IF EXISTS "Usuario_fk" CASCADE;
ALTER TABLE public."notas" ADD CONSTRAINT "usuario_fk" FOREIGN KEY ("id_usuario")
REFERENCES public."usuario" ("id") MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: "Notas_uq" | type: CONSTRAINT --
-- ALTER TABLE public."Notas" DROP CONSTRAINT IF EXISTS "Notas_uq" CASCADE;
ALTER TABLE public."notas" ADD CONSTRAINT "notas_uq" UNIQUE ("id_usuario");
-- ddl-end --

-- object: public."Notas_Categoria" | type: TABLE --
-- DROP TABLE IF EXISTS public."Notas_Categoria" CASCADE;
CREATE TABLE public."notas_categoria" (
	"id_notas" integer,
	"id_categorias" integer

);
-- ddl-end --
ALTER TABLE public."notas_categoria" OWNER TO postgres;
-- ddl-end --

-- object: "Notas_fk" | type: CONSTRAINT --
-- ALTER TABLE public."Notas_Categoria" DROP CONSTRAINT IF EXISTS "Notas_fk" CASCADE;
ALTER TABLE public."notas_categoria" ADD CONSTRAINT "notas_fk" FOREIGN KEY ("id_notas")
REFERENCES public."notas" ("id") MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: "Categoria_fk" | type: CONSTRAINT --
-- ALTER TABLE public."Notas_Categoria" DROP CONSTRAINT IF EXISTS "Categoria_fk" CASCADE;
ALTER TABLE public."notas_categoria" ADD CONSTRAINT "categoria_fk" FOREIGN KEY ("id_categorias")
REFERENCES public."categoria" ("id") MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --


