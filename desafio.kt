class Usuario(val id: Int = Random.nextInt(0..100), val name: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

    data class Formacao(val nome: String, val nivel: Nivel, var conteudos: List<ConteudoEducacional>) {
        private val inscritos = mutableListOf<Usuario>()

        fun matricular(vararg usuario: Usuario) {
            usuario.forEach {
                inscritos.add(it)
                println("${it.name}(${it.id}) foi cadastrado com sucesso no curso $nome")
            }
        }



            fun mostrarTotalMatriculas() {
                println("Há um total de ${inscritos.size} de matriculas na formação $nome")
            }
        }

        fun main() {

            val kotlinFormacao = createKotlinFormacao()
            val JavaFormacao = createJavaFormacao()

            kotlinFormacao.matricular(
            Usuario(name = "Jose"),
            Usuario(name = "Maria"),
            Usuario(name = "Pedro")
            )
            JavaFormacao.matricular(
                Usuario(name = "Sarah"),
                Usuario(name = "Rodolfo"),
                Usuario(name = "Rosangela"),
                Usuario(name = "Aline")
            )
            println("---------------------------")
            kotlinFormacao.mostrarTotalMatriculas()
            JavaFormacao.mostrarTotalMatriculas()
        }

        fun createKotlinFormacao() = Formacao(
            "Formação em Kotlin",
            Nivel.FACIL,
            listOf(
                ConteudoEducacional("Aprendendo Kotlin na prática", 13),
                ConteudoEducacional("Kotlin no backend com Spring 3", 9),
            )
        )

        fun createJavaFormacao() = Formacao(
            "Formação Java Developer",
            Nivel.INTERMEDIARIO,
            listOf(
                ConteudoEducacional("Primeiros passos com a linguagem Java", 30),
                ConteudoEducacional("POO em Java", 120),
                ConteudoEducacional("Spring Boot java", 120),
            )
        )