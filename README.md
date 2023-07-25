# EstacionamentoDeep

É possivel adicionar carros para estacionar, atualizar o valor da sua permanência e dar baixa.

Os valores a serem pagos são calculados automaticamente pelo sistema (R$10 primeira hora, +R$2 por 30 min adicional e R$90 por 12h).

O sistema também permite alternar entre uma base local e remota do AWS.

Abaixo o SQL para criar a base e suas tabelas:

    -- Criando DB
    
    CREATE DATABASE estacionamentodeep_aws;
    
    -- Criando tabelas
    
    CREATE TABLE tb_carro(id SERIAL PRIMARY KEY, nomedono varchar(255), 
    marcacarro varchar(25), placa varchar(7), estado boolean, usuario varchar(15));
    
    CREATE TABLE tb_estacionamento(id SERIAL PRIMARY KEY, carroid integer, FOREIGN KEY (carroid) REFERENCES tb_carro(id), entrada time, saida time, valorpago float,permanencia float);
