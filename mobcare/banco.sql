create database paulolirio_mobcare_bd;

drop database paulolirio_mobcare_bd;

commit;

select * 
  from paulolirio_mobcare_bd.Colaborador cob
  where cob.cpf = '30727280899';
  
insert into paulolirio_mobcare_bd.Colaborador ()
values ();

select * from paulolirio_mobcare_bd.Setor;

# id, cpf, email, nome, telefone, colaborador_id
'14', '30727280899', 'a_vanessinha_1990@hotmail.com', 'ALEXANDRA FERREIRA DA SILVA', '339200017', '1'
