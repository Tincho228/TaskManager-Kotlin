
// HELPER FUNCTIONS - Welcome message

package helperFunctions // Declaring the package
import model.Task

fun welcome() {
    println("**********************************************************************")
    println("*                                                                    *")
    println("*                       📋 TaskManager                               *")
    println("*                                                                    *")
    println("**********************************************************************")
    println("*  A simple Kotlin app to manage your tasks right from the console.  *")
    println("*                                                                    *")
    println("*                     Let's get things done! 💪                      *")
    println("**********************************************************************")
    println()
}

fun printTasksTable(tasks: List<Task>) {
    // Creating color variables
    val reset = "\u001B[0m"
    val green = "\u001B[32m"
    val red = "\u001B[31m"

    println("---------------------------------------------------------------------------------------------")
    println("| Index | Status |  Status-desc  |        Title        |       Description                 |")
    println("---------------------------------------------------------------------------------------------")

    for ((index, task) in tasks.withIndex()) {
        val symbol = if (task.done) "✅" else "❌"
        val statusTextRaw = if (task.done) "Done" else "Incomplete"
        val statusColored = if (task.done) "$green$statusTextRaw$reset" else "$red$statusTextRaw$reset"
        val statusPadded = statusColored + " ".repeat(14 - statusTextRaw.length) // pad visually, not by string length

        val title = task.title.padEnd(20).take(20)
        val desc = task.description.padEnd(30).take(30)
        val idx = (index + 1).toString().padEnd(5)

        println("|  $idx |   $symbol   | $statusPadded | ${title} | ${desc} |")
    }

    println("---------------------------------------------------------------------------------------------")
}

fun printConfirmationCard(operation: String): Boolean {
    val reset = "\u001B[0m"
    val green = "\u001B[32m"
    val red = "\u001B[31m"
    val cyan = "\u001B[36m"
    val yellow = "\u001B[33m"
    val bold = "\u001B[1m"

    val (symbol, message) = when (operation.lowercase()) {
        "delete" -> "🗑️" to "${red}Are you sure you want to delete this task?$reset"
        "add" -> "➕" to "${green}Are you sure you want to add this task?$reset"
        "done" -> "✅" to "${cyan}Mark this task as done?$reset"
        else -> "❓" to "${yellow}Unknown operation.$reset"
    }

    println("╔════════════════════════════════════════╗")
    println("║  $symbol  $message")
    println("║                                        ║")

    while (true) {
        print("║  ${bold}Type${reset} ${green}Y$reset/${red}N$reset to confirm: ")
        val input = readLine()?.trim()?.lowercase()

        if (input == "y") {
            println("╚════════════════════════════════════════╝")
            return true
        } else if (input == "n") {
            println("╚════════════════════════════════════════╝")
            return false
        } else {
            println("║  ${red}Invalid input. Please enter Y or N.$reset")
        }
    }
}


