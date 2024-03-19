




(def carrusel '((11 Tijeras 15 30 1 1) (12 Cuadernos 25 15 1 2) (13 Resistol 15 10 1 3) (14 Borrador 30 3 1 4) (15 Lapiz 40 2 1 5)
                                       (21 Plumon 40 8 2 1) (22 Libros 10 100 2 2) (23 Sacapuntas 16 4 2 3) (24 Carpetas 8 2 2 4) (25 Papel 15 4 2 5)
                                       (31 Pizarron 3 120 3 1) (32 Cuchillos 10 80 3 2) (33 Charolas 20 80 3 3) (34 Platos 20 50 3 4) (35 Tenedores 30 8 3 5)
                                       (41 Estufas 20 150 4 1) (42 Cucharas 20 14 4 2) (43 Audifonos 20 120 4 3) (44 Mangueras 8 70 4 4) (45 Manteles 20 30 4 5)
                                       (51 Linternas 4 100 5 1) (52 Lamparas 4 80 5 2) (53 Mini_Ventiladores 20 20 5 3) (54 Paraguas 8 40 5 4) (55 Gorras 20 20 5 5)
                                       (61 Teclados 4 120 6 1) (62 Sabanas 2 50 6 2) (63 Canicas 90 6 6 3) (64 Termos 8 80 6 4) (65 Pulseras 30 10 6 5)
                                       (71 Alcancias 6 30 7 1) (72 Microfonos 3 110 7 2) (73 CDs 50 40 7 3) (74 Peluches 8 16 7 4) (75 Relojes 15 80 7 5)
                                       (81 Cubrebocas 20 15 8 1) (82 Batas 8 140 8 2) (83 Estuches 20 6 8 3) (84 Espatulas 20 15 8 4) (85 Caserolas 15 30 8 5)
                                       (91 Item41 4 10 9 1) (92 Item42 10 2 9 2) (93 Item43 20 6 9 3) (94 Item44 8 4 9 4) (95 Item45 15 10 9 5)
                                       (101 Item46 4 10 10 1) (102 Item47 10 2 10 2) (103 Item48 20 6 10 3) (104 Item49 8 4 10 4) (105 Item50 15 10 10 5)
                                       (111 Item51 4 10 11 1) (112 Item52 10 2 11 2) (113 Item53 20 6 11 3) (114 Item54 8 4 11 4) (115 Item55 15 10 11 5)
                                       (121 Item56 4 10 12 1) (122 Item57 10 2 12 2) (123 Item58 20 6 12 3) (124 Item59 8 4 12 4) (125 Item60 15 10 12 5)
                                       (131 Item61 4 10 13 1) (132 Item62 10 2 13 2) (133 Item63 20 6 13 3) (134 Item64 8 4 13 4) (135 Item65 15 10 13 5)
                                       (141 Item66 4 10 14 1) (142 Item67 10 2 14 2) (143 Item68 20 6 14 3) (144 Item69 8 4 14 4) (145 Item70 15 10 14 5)
                                       (151 Item71 4 10 15 1) (152 Item72 10 2 15 2) (153 Item73 20 6 15 3) (154 Item74 8 4 15 4) (155 Item75 15 10 15 5)
                                       (161 Item76 4 10 16 1) (162 Item77 10 2 16 2) (163 Item78 20 6 16 3) (164 Item79 8 4 16 4) (165 Item80 15 10 16 5)
                                       (171 Item81 4 10 17 1) (172 Item82 10 2 17 2) (173 Item83 20 6 17 3) (174 Item84 8 4 17 4) (175 Item85 15 10 17 5)
                                       (181 Item86 4 10 18 1) (182 Item87 10 2 18 2) (183 Item88 20 6 18 3) (184 Item89 8 4 18 4) (185 Item90 15 10 18 5)
                                       (191 Item91 4 10 19 1) (192 Item92 10 2 19 2) (193 Item93 20 6 19 3) (194 Item94 8 4 19 4) (195 Item95 15 10 19 5)
                                       (201 Item96 4 10 20 1) (202 Item97 10 2 20 2) (203 Item98 20 6 20 3) (204 Item99 8 4 20 4) (205 Item100 15 10 20 5)))


(defn randomRetirar [] (rand-int 15)) ;  Funcion para crear numeros enteros aleatorios (razonables para retirar)

(defn randomAgregar [ ] (rand-int 20)) ;  Funcion para crear numeros enteros aleatorios (razonables para agregar)





(defn crearCarruselAleatorio [carrusel] 
  (cond (nil? carrusel) carrusel
        :else  (cons (list (nth (first carrusel) 0) (nth (first carrusel) 1) 
                           (rand-int 101) (nth (first carrusel) 3) (nth (first carrusel) 4) (nth (first carrusel) 5)) (next carrusel))
        )
  )
; Esta función nos ayuda a crear un carrusel con cantidades aleatorias de inventario


(defn crearCarruseles [n] (loop [x n]
                        (when (> x 1)
                          (spit (str "./carrusel" x ".txt") (crearCarruselAleatorio carrusel))
                          (recur (- x 1))))
)

; Estas funciones nos ayudan a crear carruseles en un  rango de 0 a n. Cada uno es único ya que es creado con 
; una función que pone cantidades (aleatorios)





; Esta funcion crea comandos aleatorios
(defn CrearComandosAleatorios [] `((~'Retirar ~(randomRetirar)) (~'Mover (~'derecha ~'derecha ~'abajo)) (~'AgregarProducto ~'Cucharas ~(randomAgregar)) 
                                   (~'Agregar ~(randomAgregar)) (~'RetirarProducto ~'Resistol ~(randomRetirar)) (~'Mover (~'izquierda)) (~'Agregar ~(randomAgregar))))

(defn CrearComandosT [n] (loop [x n]
                            (when (> x 1)
                              (spit (str "./comandos" x ".txt") (CrearComandosAleatorios))
                              (recur (- x 1)))))


; Esta funcion crea los archivos con los comandos 



(defn crearLista [inicio final]
  (spit "numeros.txt" (range inicio (+ final 1))) ; Esta funcion crea una lista con los numeros de los carruseles
  )


(crearLista 2 5000)

(CrearComandosT 5000)

(crearCarruseles 5000)