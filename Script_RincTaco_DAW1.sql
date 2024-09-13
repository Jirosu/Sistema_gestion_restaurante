-- Verificar si la base de datos existe y, si es así, eliminarla
DROP DATABASE IF EXISTS BDRincTaco_DAWI;

-- Crear la base de datos
CREATE DATABASE BDRincTaco_DAWI;

-- Utilizar la base de datos recién creada
USE BDRincTaco_DAWI;

-- Crear la tabla categoria_producto
CREATE TABLE categoria_producto (
    codCatProd CHAR(2) PRIMARY KEY,
    descCatProd VARCHAR(50) NOT NULL
);

-- Crear la tabla estado_producto
CREATE TABLE estado_producto (
    codEstProd CHAR(2) PRIMARY KEY,
    descEstProd VARCHAR(45) NOT NULL
);

-- Crear la tabla producto (se agregó rutaImg)
CREATE TABLE producto (
    codProd CHAR(6) PRIMARY KEY,
    nomProd VARCHAR(45) NOT NULL,
    descProd VARCHAR(200) NOT NULL,
    precProd DECIMAL(10,2) NOT NULL,    
    rutaImg VARCHAR(200) NOT NULL,
    codCatProd CHAR(2) NOT NULL,
    codEstProd CHAR(2) DEFAULT('01') NOT NULL,    
    FOREIGN KEY (codEstProd) REFERENCES estado_producto(codEstProd),
    FOREIGN KEY (codCatProd) REFERENCES categoria_producto(codCatProd)
);

-- Crear la tabla usuario
CREATE TABLE usuario (
    codUsu CHAR(8) PRIMARY KEY,
    nomUsu VARCHAR(45) NOT NULL,
    apeUsu VARCHAR(45) NOT NULL,
    usuario VARCHAR(30) NOT NULL,
    contrasena VARCHAR(25) NOT NULL,
    rolUsu VARCHAR(13) NOT NULL
);


-- Insertar datos en la tabla usuario
INSERT INTO usuario (cod_usu, nom_usu, ape_usu, usuario, contrasena, rol_usu) 
	VALUES ('01234567', 'Jose', 'Arguedas', 'jose1', '12345', 'Administrador'), 
			('76543210', 'Fran', 'Hernandez', 'fran2', '54321', 'Cliente');
select * from usuario;

-- Insertar datos en la tabla categoria_producto
INSERT INTO categoria_producto (cod_cat_prod, desc_cat_prod)
VALUES ('01', 'Tacos'), ('02', 'Enchiladas'), ('03', 'Burritos'), ('04', 'Sanguches'), ('05', 'Bebidas'), ('06', 'Postres');

describe categoria_producto;
select * from categoria_producto;

-- Insertar datos en la tabla estado_producto
INSERT INTO estado_producto (cod_est_prod, desc_est_prod)
VALUES ('01', 'Habilitado'), ('02', 'Deshabilitado');
describe estado_producto;
select * from estado_producto;

-- Insertar TACOS en la tabla producto
INSERT INTO producto (cod_prod, nom_prod, desc_prod, prec_prod, ruta_img, cod_cat_prod, cod_est_prod)
VALUES
('TAC001', 'Tacos al pastor', 'Tortilla de maíz rellena con carne de cerdo condimentada con una salsa de especias y chiles secos.', 13.90, '/static/Img/tacosalpastor.jpg', '01', '01'),
('TAC002', 'Tacos de Carnitas', 'Tortilla de maíz rellena con carne de cerdo frita en manteca en manteca, sal y tequesquite, acompañado con especias y ajo.', 14.90, '/static/Img/tacosdecarnitas.jpg', '01', '01'),
('TAC003', 'Tacos Dorados', 'Tortilla de maíz enrollada y frita rellena con pollo deshilachado, res, cerdo o barbacoa, frijol y papa con queso.', 14.90, '/static/Img/tacosdorados.webp', '01', '01'),
('TAC004', 'Tacos de Cecina', 'Tortilla de maíz rellena de cecina de res acompañada de cebolla, chile, culantro y especias.', 16.90, '/static/Img/tacosdececina.jpg', '01', '01'),
('TAC005', 'Tacos de Pescado', 'Tortilla de maíz rellena de pescado rebozado en harina y huevo, acompañado de cebolla y especias.', 17.90, '/static/Img/tacosdepescado.jpg', '01', '01'),
('TAC006', 'Tacos Gobernador', 'Tortilla de maíz rellena de camarones salteados con orégano, ajo, chile poblano y pasta de tomates, acompañados con cebolla, especias y queso gratinado.', 19.90, '/static/Img/tacosgobernador.jpg', '01', '01');

-- Insertar ENCHILADAS en la tabla producto
INSERT INTO producto (cod_prod, nom_prod, desc_prod, prec_prod, ruta_img, cod_cat_prod, cod_est_prod)
VALUES
('ENC001', 'Enchiladas Rojas', 'Tortillas de maíz fritas y enrolladas bañadas en salsa de chiles rojos y tomates, rellenas de pollo deshilachado, cebolla y queso gratinado.', 12.90, '/static/Img/enchiladasrojas.jpg', '02', '01'),
('ENC002', 'Enchiladas Verdes', 'Tortillas de maíz enrolladas bañadas en salsa de chiles y culantro rellenas de pollo deshilachado acompañadas de queso crema, cebolla y cilantro picado.', 12.90, '/static/Img/enchiladasverdes.webp', '02', '01'),
('ENC003', 'Enchiladas de Chile','Tortillas de maíz horneadas enrolladas y bañadas en salsa de chiles pasilla y salsa de tomate rellenas de pollo deshilachado cebolla y espolvoreadas con queso.', 14.90, '/static/Img/enchiladasdechile.jpg', '02', '01'),
('ENC004', 'Enchiladas Suizas', 'Tortillas de maíz horneadas enrolladas, bañadas en salsa de chiles tomate, cebolla, culantro y crema rellenas con pollo y gratinadas con queso manchego.', 17.90, '/static/Img/enchiladassuizas.jpg', '02', '01');

-- Insertar BURRITOS en la tabla producto
INSERT INTO producto (cod_prod, nom_prod, desc_prod, prec_prod, ruta_img, cod_cat_prod, cod_est_prod)
 VALUES
('BUR001', 'Burrito de Pollo', 'Tortillas de harina de trigo enrollada rellena de pollo en trozos y pimiento salteado, guacamole, lechuga y queso.', 12.90, '/static/Img/burritodepollo.jpg', '03', '01'),
('BUR002', 'Burrito de Carne', 'Tortillas de harina de trigo enrollada rellena de carne de cerdo en trozos y pimiento salteado, guacamole, lechuga y queso.', 13.90, '/static/Img/burritodecarnes.jpg', '03', '01'),
('BUR003', 'Burrito de Jamon y Queso','Tortillas de harina de trigo enrollada rellena de jamón, queso cheddar, guacamole y lechuga.', 11.90, '/static/Img/burritodejamonyqueso.jpeg', '03', '01');

-- Insertar SANGUCHES en la tabla producto
INSERT INTO producto (cod_prod, nom_prod, desc_prod, prec_prod, ruta_img, cod_cat_prod, cod_est_prod)
 VALUES
('SAN001', 'Hamburguesa Clásica', 'Pan brioche relleno de hamburguesa de carne molida a la plancha acompañada de lechuga, tomate, cebolla y pepinillos.', 9.90, '/static/Img/hamburguesaclasica.jpg', '04', '01'),
('SAN002', 'Cheese Burger', 'Pan brioche relleno de hamburguesa de carne molida a la plancha acompañada de dos rebanadas de queso cheddar lechuga, tomate, cebolla, pepinillos.', 11.90, '/static/Img/cheeseburguer.jpg', '04', '01'),
('SAN003', 'Hamburguesa Royale','Pan brioche relleno de hamburguesa de carne molida a la plancha acompañada de huevo frito, tocino, queso cheddar, lechuga, tomate, cebolla, pepinillos.', 13.90, '/static/Img/hamburguesaroyale.jpg', '04', '01'),
('SAN004', 'Sanguche de pollo', 'Pan brioche relleno de pechuga de pollo deshilachada acompañada de lechuga, tomate, cebolla y pepinillos.', 8.90, '/static/Img/sanguchedepollo.jpg', '04', '01');

-- Insertar BEBIDAS en la tabla producto
INSERT INTO producto  (cod_prod, nom_prod, desc_prod, prec_prod, ruta_img, cod_cat_prod, cod_est_prod)
VALUES
('BEB001', 'Inca Kola', 'Gaseosa Inca Kola botella personal de 500ml.', 3.50, '/static/Img/incakola.png', '05', '01'),
('BEB002', 'Coca-Cola', 'Gaseosa Coca-Cola botella personal de 500ml.', 3.50, '/static/Img/coca-cola.png', '05', '01'),
('BEB003', 'Chicha Morada', 'Jarra de 1 litro de chicha morada.', 6.90, '/static/Img/chichamorada.png', '05', '01'),
('BEB004', 'Maracuyá', 'Jarra de 1 litro de jugo de maracuyá.', 6.90, '/static/Img/maracuya.png', '05', '01'),
('BEB005', 'Agua', 'Botella de agua San Mateo personal 600ml.', 3.00, '/static/Img/botella_agua.png', '05', '01');

-- Insertar POSTRES en la tabla producto
INSERT INTO producto  (cod_prod, nom_prod, desc_prod, prec_prod, ruta_img, cod_cat_prod, cod_est_prod)
VALUES
('POS001', 'Churros', 'Churros fritos cubiertos de azúcar rellenos de manjar, chocolate o crema pastelera.', 6.90, '/static/Img/churros.jpg', '06', '01'),
('POS002', 'Torta de Chocolate', 'Porción de torta de chocolate y manjar.', 7.90, '/static/Img/tortadechocolate.jpg', '06', '01'),
('POS003', 'Helado','Copa de helado de sabores variados a elegir.', 4.90, '/static/Img/helado.jpg', '06', '01');


SELECT * FROM usuario;
SELECT * FROM estado_producto;
SELECT * FROM categoria_producto;
SELECT * FROM producto;
