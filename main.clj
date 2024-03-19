

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

;; Este carrusel no se usa en el simulador, pero fue referencia para hacer las pruebas en un inicio


(def ventana 11)
; Aqui definimos que la ventana se encuentra en el objeto 11 al iniciar el carrusel


(defn filaBase [ventana carrusel]
  (if (= ventana (first (first carrusel))) (nth (first carrusel) 4) (filaBase ventana (next carrusel))))
; Esta funcion nos ayuda a obtener la fila del objeto que se encuentra en la ventana en ese momento

(defn colBase [ventana carrusel]
  (if (= ventana (first (first carrusel))) (nth (first carrusel) 5) (colBase ventana (next carrusel))))
; Esta funcion nos ayuda a obtener la columna del objeto que se encuentra en la ventana en ese momento


(defn filaTop [nombre carrusel]
  (if (= nombre (nth (first carrusel) 1)) (nth (first carrusel) 4) (filaTop nombre (next carrusel))))
;Con esta funcion obtenemos la fila del objeto por nombre


(defn colTop [nombre carrusel]
  (if (= nombre (nth (first carrusel) 1)) (nth (first carrusel) 5) (colTop nombre (next carrusel))))
;Con esta funcion obtenemos la columna del objeto por nombre 

; movimientos 

(defn movimientos [fila1 columna1 fila2 columna2]
  (cond (> fila1 fila2)
        (cond (< (- fila1 fila2) (+ (- 20 fila1) fila2))
              (cond (< columna1 columna2) (println (str (- fila1 fila2)) "arriba" (str (- columna2 columna1)) "derecha") (newline)
                    :else (println (str (- fila1 fila2)) "arriba" (str (- columna1 columna2)) "izquierda") (newline))
              :else (cond (< columna1 columna2) (print (str (+ (- 20 fila1) fila2)) "abajo" (str (- columna2 columna1)) "derecha") (newline)
                          :else (println (str (+ (- 20 fila1) fila2)) "abajo" (str (- columna1 columna2)) "izquierda") (newline)))
        (> fila2 fila1)
        (cond (< (- fila2 fila1) (+ (- 20 fila2) fila1))
              (cond (< columna1 columna2) (println (str (- fila2 fila1)) "abajo" (str (- columna2 columna1)) "derecha") (newline)
                    :else (println (str (- fila2 fila1)) "abajo" (str (- columna1 columna2)) "izquierda") (newline))

              :else (cond (< columna1 columna2) (print (str (+ (- 20 fila2) fila1)) "arriba" (str (- columna2 columna1)) "derecha") (newline)
                          :else (println (str (+ (- 20 fila2) fila1)) "arriba" (str (- columna1 columna2)) "izquierda") (newline)))

        :else (cond (< columna1 columna2) (print (str (- columna2 columna1)) "derecha") (newline)
                    :else (println (str (- columna1 columna2)) "izquierda") (newline))))
; Esta es la implementacion del algoritmo que checa que movimiento es mejor dependiendo de la distancia entre las filas
;del objeto en ventana hasta el objeto al que se quiere llegar para agregar o retirar.

;Esta función es muy importante para que el carrusel indique los movimientos que hizo 



(defn imprime [x] (println x))

(defn retirar [carrusel ventana cantidad]
  (cond (nil? carrusel) carrusel
        (= (first (first carrusel)) ventana)
        (cond (> cantidad (nth (first carrusel) 2))
              (cons (list ventana (nth (first carrusel) 1) 0 (nth (first carrusel) 3) (nth (first carrusel) 4) (nth (first carrusel) 5)) (next carrusel))
              :else (cons (list ventana (nth (first carrusel) 1) (- (nth (first carrusel) 2) cantidad) (nth (first carrusel) 3) (nth (first carrusel) 4) (nth (first carrusel) 5)) (next carrusel)))

        :else (cons (first carrusel) (retirar (next carrusel) ventana cantidad))))


; Aqui retiramos cierta cantidad del objeto que esté en la ventana en ese momento
; También checamos si la cantidad es mayor de la que actualmente hay, para dar el aviso


(defn agregar [carrusel ventana cantidad]
  (cond (nil? carrusel) carrusel
        (= (first (first carrusel)) ventana) (cons (list ventana (nth (first carrusel) 1) (+ (nth (first carrusel) 2) cantidad) (nth (first carrusel) 3) (nth (first carrusel) 4) (nth (first carrusel) 5)) (next carrusel))
        :else (cons (first carrusel) (agregar (next carrusel) ventana cantidad))))
; Aqui agregamos cierta cantidad del objeto que esté en la ventana en ese momento



(defn retirarProducto [carrusel nombre cantidad]
  (cond (nil? carrusel) carrusel
        (= (nth (first carrusel) 1) nombre)
        (cond (> cantidad (nth (first carrusel) 2)) (cons (list (first (first carrusel)) nombre 0 (nth (first carrusel) 3) (nth (first carrusel) 4) (nth (first carrusel) 5)) (next carrusel))
              :else (cons (list (first (first carrusel)) nombre (- (nth (first carrusel) 2) cantidad) (nth (first carrusel) 3) (nth (first carrusel) 4) (nth (first carrusel) 5)) (next carrusel)))
        :else (cons (first carrusel) (retirarProducto (next carrusel) nombre cantidad))))
; Aqui retiramos cierta cantidad de un objeto por su nombre



(defn agregarProducto [carrusel nombre cantidad]
  (cond (nil? carrusel) carrusel
        (= (nth (first carrusel) 1) nombre) (cons (list (first (first carrusel)) nombre (+ (nth (first carrusel) 2) cantidad) (nth (first carrusel) 3) (nth (first carrusel) 4) (nth (first carrusel) 5)) (next carrusel))
        :else (cons (first carrusel) (agregarProducto (next carrusel) nombre cantidad))))
; Aqui agregamos cierta cantidad de un objeto por su nombre


(defn buscarNombre [carrusel nombre]
  (cond (nil? carrusel) 0
        (= (nth (first carrusel) 1) nombre) (first (first carrusel))
        :else (buscarNombre (next carrusel) nombre)))
; Esta es una funcion de ayuda para obtener el numero de la ventana dando su nombre



(defn gestorMovimientos [ventana comando carrusel]
  (cond (= 'RetirarProducto (first comando))
        (movimientos (filaBase ventana carrusel) (colBase ventana carrusel)
                     (filaTop (nth comando 1) carrusel) (colTop (nth comando 1) carrusel))
        (= 'AgregarProducto (first comando))
        (movimientos (filaBase ventana carrusel) (colBase ventana carrusel)
                     (filaTop (nth comando 1) carrusel) (colTop (nth comando 1) carrusel))

        :else nil))
; Esta función se encarga de mostrar en pantalla los movimientos que hizo el carrusel para llegar de un objeto a otro
; tambien muy importante


(defn interfaz [carrusel ventana comando]
  (gestorMovimientos ventana comando carrusel)
  (cond (= 'Retirar (first comando)) (retirar carrusel ventana (nth comando 1))
        (= 'Agregar (first comando)) (agregar carrusel ventana (nth comando 1))
        (= 'RetirarProducto (first comando)) (retirarProducto carrusel (nth comando 1) (nth comando 2))
        (= 'AgregarProducto (first comando)) (agregarProducto carrusel (nth comando 1) (nth comando 2))
        :else carrusel))
; Esta funcion nos ayuda a manejar que operacion se va a realizar dependiendo del comando que se le de


(defn mover [instruccion]
  (cond (nil? instruccion) 0
        (= (first instruccion) 'derecha) (+ (mover (next instruccion)) 1)
        (= (first instruccion) 'izquierda) (- (mover (next instruccion)) 1)
        (= (first instruccion) 'abajo) (+ (mover (next instruccion)) 10)
        (= (first instruccion) 'arriba) (- (mover (next instruccion)) 10)

        :else (mover (next instruccion))))
; Esta funcion se encarga de llevar un registro de los movimientos para determinar en que ventana
; deberá estar dependiendo de los movimientos



(defn gestorVentana [ventana comando carrusel]
  (cond (nil? comando) ventana
        (= 'Mover (first comando)) (+ ventana (mover (nth comando 1)))
        (= 'RetirarProducto (first comando) (buscarNombre carrusel (nth comando 1)))
        (= 'AgregarProducto (first comando) (buscarNombre carrusel (nth comando 1)))
        :else ventana))
; Esta funcion actualiza el valor como tal de la ventana despues de que le llegan los comandos
; de (Mover (derecha izquierda... etc))

(defn pocoInventario [carrusel]
  (cond (nil? carrusel) '()
        (< (nth (first carrusel) 2) 10) (cons (first carrusel) (pocoInventario (next carrusel)))
        :else (pocoInventario (next carrusel))))
; Esta funcion crea una lista con los objetos que tienen poco inventario < 10


(defn reordenInventario [carrusel]
  (cond (nil? carrusel) '()
        (= (nth (first carrusel) 2) 0) (cons (first carrusel) (reordenInventario (next carrusel)))
        :else (reordenInventario (next carrusel))))
; Esta funcion crea una lista con los objetos que tienen 0 inventario


(defn cantidadPorProducto [carrusel]
  (cond (nil? carrusel) '()
        :else (cons (* (nth (first carrusel) 2) (nth (first carrusel) 3)) (cantidadPorProducto (next carrusel)))))
; Esta funcion crea una lista con el valor de cada producto. Precio * cantidad


(defn totalInventario [lista]
  (apply + lista))
; Aqui sumamos todos los valores de una lista ( lo que regresa la funcion de arriba)


(defn sumaTotal [carrusel] (totalInventario (cantidadPorProducto carrusel)))
; esta funcion es solo juntar las dos de arriba para obtener el valor total del almacen
; con una sola llamada 


;-------------------------

(defn imprimeV [carrusel ventana]
  (println "Productos con poco inventario"  (pocoInventario carrusel))
  (println "Valor total del carrusel" (sumaTotal carrusel))
  (println "En ventana" ventana)
  (println carrusel))


(defn maestra [ventana carrusel comandos]
  (cond (nil? comandos) (imprimeV carrusel ventana)
        :else
        (maestra (gestorVentana ventana (first comandos) carrusel) (interfaz carrusel ventana (first comandos)) (next comandos))))




; Como su nombre lo dice, esta es la funcion maestra, La que lleva a acabo todo el simulador y se va pasando la matriz
; por los parametros que a su vez son funciones que van actualizando la ventana dependiendo de los comandos que se le dan

; Estoy muy orgulloso de esta función ya que me permitió mutar la misma matriz sin tener que usar let o declararla de manera local, usando
; el paradigma funcional en su maxima expresión. Cambiando el carrusel hasta que ya no haya más comandos.




(def lista (read-string (slurp "numeros.txt"))) ;; Lista con numeros de los carruseles 

;-------------------------------------------------
; Consideraciones extra 

;Suma del almacen 

(defn SumaAlmacen [id]
  (def carrusel2 (read-string (slurp (apply str "./carrusel" id ".txt"))))

  (doall (seq carrusel2))

  (sumaTotal carrusel2)
  )



; top carruseles con mayor inventario 

(defn promedio2 [n]
  (float (/ (apply + (map #(SumaAlmacen %) lista)) n))) ; Obtenemos el promedio del carrusel

(defn map-indexed-from [n f coll]
  (map f (range n Double/POSITIVE_INFINITY) coll)) ; Esta funcion nos ayuda a empezar la lista del vector desde n numero


(def sumaCarruseles (map-indexed-from 2 vector (map #(SumaAlmacen %) lista)))


(def promedioFinal (promedio2 1998))

;(print (filter #(> (second %) promedioFinal) sumaCarruseles)) ; Aqui obtenemos la lista con los carruseles que tienen mayor inventario y su numero



;; Carruseles con los items que necesitan reinventario
; Item con poco inventario 

(defn carruselReorden [id]
  (def carrusel4 (read-string (slurp (apply str "./carrusel" id ".txt"))))


  (reordenInventario carrusel4))

; Esta funcion nos ayuda a obtener los items que necesiten reorden del carrusel

(def sinInventario (map-indexed-from 2 vector (map #(carruselReorden %) lista))); Aqui usamos la funcion para obtener los item que neceisten reorden
; y la aplicamos a todos los carruseles para obtener la lista 

;(print sinInventario)



;-------------------------------------------------


(defn principal [ventana carrusel comandos id]
  (maestra ventana carrusel comandos)
  (spit (apply str "./carrusel" id ".txt") (interfaz carrusel ventana (first comandos)))
  )

;Con esta función llamamos a la función maestra y actualizamos el archivo de texto con el inventario
; correspondiente de acuerdo a los comandos


(defn aplicarFuncion [id] 
  (def carrusel (read-string (slurp (apply str "./carrusel" id ".txt"))))
  (def comandos (read-string (slurp (apply str "./comandos" id ".txt")))) 

  (doall (seq carrusel))
  (doall (seq comandos))

  
  (principal ventana carrusel comandos id) 
  )
; Esta funcion hace posible usar el map y pmap en la lista de los numeros de los carruseles 
; para pasar como parametro el numero y esta funcion se encarga de actualizar los carruseles y avisar
; de la suma del almacen, los que tienen mayor valor y los que necesitan reorden




; Funciones para provar eficiencia 



;(time (doall (map #(aplicarFuncion %) lista)))  ;Secuencial - map



;(time (doall (pmap #(aplicarFuncion %) lista)))  ; Paralelo - pmap


(time (dorun (pmap (fn [lista] (dorun (map #(aplicarFuncion %) lista))) (partition-all 500 lista)))) ; map con pmap, partiendo las listas 


(println)
(println)
(println "Suma del almacen total:")
(print(apply +(doall (map #(SumaAlmacen %) lista))))  ;Suma total  del almacen
(println)
(println)

(println "Los top carruseles con mayor valor de inventario:")
(print (filter #(> (second %) 29000) sumaCarruseles)) ; Aqui  usamos la funcion de arriba comentada 
; para obtener la lista con los carruseles que tienen mayor inventario y su numero
(println)
(println)
(println "Carruseles que necesiten reinventario, con su respectivo numero y producto:")
(print sinInventario) ; Aqui usamos la funcion de arriba para imprimir los carruseles que necesiten inventario y su respectivo numero de carrusel



