(ns forca.core
  (:gen-class))

(def NumChances 6)
(def advinhaPalavra "PARADIGMAS") 

(defn jogoPerdido [] (println "VOCE PERDEU!"))
(defn ganhou [] (println "VOCE GANHOU!")) 

(defn faltaLetra [advPalavra acertos]
	(remove (fn [contIncrement] (contains? acertos (str contIncrement))) advPalavra))

(defn contador [advPalavra acertos] 
	(empty? (faltaLetra advPalavra acertos)))

(defn scanEfe! [] (read-line))

(defn existePalavra [chutou advPalavra] (.contains advPalavra chutou))

(defn SituacaoForca [chances advPalavra acertos]
	(println "Total de:" chances "vidas") 
	(doseq [contIncrement (seq advPalavra)] 
	(if (contains? acertos (str contIncrement)) 
	(print contIncrement " ")))
	(println))	

(defn Forca [chances advPalavra acertos]
	(SituacaoForca chances advPalavra acertos)
	(cond (= chances 0)(jogoPerdido)
	(contador advPalavra acertos)(ganhou)
	:else
	(let [chutou (scanEfe!)]
	(if (existePalavra chutou advPalavra)
	(Forca chances advPalavra (conj acertos chutou))
	(Forca (- chances 1) advPalavra acertos)))))

(defn inicio [] (Forca NumChances advinhaPalavra #{}))

(defn -main  [& args]
	(println)
	(println)
	(println "P.I DE PARADIGMAS DE PROGRAMACAO - 1/2016 ")
	(println "Orientador: Prof. MSc Cristiano Lehrer ")
	(println "Aluno: Nicolas Alexandre - 1212130027 ")
	(println)
	(println)
	(println "Dica: Tem relacao com 22:00 hrs ;D ")
  (inicio))
