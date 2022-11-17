ALTER TABLE public.notas DROP CONSTRAINT usuario_fk;
alter table public.notas add constraint usuario_fk foreign key (id_usuario) references public.usuario(id) on
    delete
    cascade on
    update
    cascade match full;


ALTER TABLE public.categoria DROP CONSTRAINT usuario_fk;
alter table public.categoria add constraint usuario_fk foreign key (id_usuario) references public.usuario(id) on
    delete
    cascade;

alter table public.notas_categoria drop constraint categoria_fk;

alter table public.notas_categoria add constraint categoria_fk foreign key (id_categorias) references public.categoria(id) on
    delete
    cascade on
    update
    cascade match full;

alter table public.notas_categoria drop constraint notas_fk;

alter table public.notas_categoria add constraint notas_fk foreign key (id_notas) references public.notas(id) on
    delete
    cascade on
    update
    cascade match full;