ALTER TABLE public."categoria" ADD CONSTRAINT "usuario_fk" FOREIGN KEY ("id_usuario")
REFERENCES public."usuario" ("id")