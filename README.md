Paragraph Stack Explorer
Description

Paragraph Stack Explorer is a Java Swing GUI application that demonstrates how the Stack data structure works using a paragraph of text.

The application takes a paragraph, separates it into individual words, and stores those words in a Java Stack<String>. Since a stack follows the Last-In, First-Out (LIFO) principle, the last word pushed onto the stack becomes the top item.

The application provides several buttons that allow the user to load, display, reverse, search, add, view, remove, and clear items from the stack.

Features
Load Paragraph
Reads the paragraph from the source text area, cleans the text, separates it into words, and pushes each word onto the stack.
Display Stack
Displays the contents of the stack from the top item to the bottom item.
Reverse Paragraph
Uses the stack to display the words in reverse order.
Push Word
Adds a new word to the top of the stack.
Search Position
Searches for a word using the Stack.search() method and displays its position relative to the top of the stack.
Peek Top
Displays the item currently at the top of the stack without removing it.
Pop Top
Removes and displays the top item from the stack.
Clear Stack
Removes all items from the stack.
Technologies Used
Java
Java Swing
Java AWT
java.util.Stack
Event-driven programming
ActionListener
Data Structure

The application uses:

Stack<String> words;

A stack follows the LIFO (Last-In, First-Out) principle.

For example, if the following words are pushed:

Java
Stack
Programming

The stack will look like:

TOP → Programming
      Stack
      Java

The pop() operation will therefore remove Programming first.

Stack Methods Demonstrated

The project demonstrates several methods provided by Java's Stack class:

Method	Purpose
push()	Adds an item to the top of the stack
pop()	Removes and returns the top item
peek()	Returns the top item without removing it
search()	Finds an item's position relative to the top
empty()	Checks whether the stack is empty
clear()	Removes all items from the stack
Input Processing

When the paragraph is loaded, the program:

Removes leading and trailing spaces.
Converts the text to lowercase.
Removes characters that are not letters or spaces.
Removes unnecessary whitespace.
Splits the paragraph into individual words.
Pushes each word onto the stack.
Event Handling

Each button has its own private listener class implementing ActionListener.

For example:

private class PushWordListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Button logic
    }
}

This demonstrates event-driven programming, where code is executed in response to user actions such as clicking a button.

Project Structure
ParagraphStackExplorer/
│
├── ParagraphStackExplorer.java
└── README.md
How to Run
Open the project in a Java IDE such as NetBeans, IntelliJ IDEA, or Eclipse.
Make sure a Java Development Kit (JDK) is installed.
Open ParagraphStackExplorer.java.
Compile the program.
Run the main() method.
The Paragraph Stack Explorer GUI will appear.
Learning Objectives

This project demonstrates:

Creating a Java Swing GUI.
Using JFrame, JPanel, JTextArea, JTextField, JButton, and JLabel.
Implementing ActionListener.
Creating private listener classes.
Working with the Java Stack collection.
Understanding the LIFO principle.
Using stack operations such as push, pop, peek, and search.
Processing and cleaning strings.
Responding to user interaction through event-driven programming.

Paragraph Stack Explorer — Java GUI Project
