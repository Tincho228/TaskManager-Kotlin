// MOCK DATA BASE - It creates a fake database to start with.
package model

fun getMockTasks(): List<Task> {
    return listOf(
        Task("Buy groceries", "Milk, Eggs, Bread"),
        Task("Study Kotlin", "Read about data classes"),
        Task("Workout", "Go for a 30-min run"),
        Task("Write blog", "Post about Kotlin basics"),
        Task("Call mom", "Check in and chat"),
        Task("Clean room", "Tidy up the desk and shelves"),
        Task("Read a book", "Finish the current chapter"),
        Task("Plan weekend", "Make plans with friends", done = true)
    )
}
