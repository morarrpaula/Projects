package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToDoListApp {
    private DefaultListModel<String> taskListModel;
    private JList<String> taskList;
    private JTextField taskField;
    private int taskCounter;

    public ToDoListApp() {
        taskCounter = 1;  // Inițializează contorul

        JFrame frame = new JFrame("To-Do List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);
        taskField = new JTextField(20);



        JButton addButton = new JButton("Adaugă task");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String task = taskField.getText();
                if (!task.isEmpty()) {
                    String numberedTask = taskCounter + ". " + task; // Adaugă task numerotat
                    taskListModel.addElement(numberedTask);
                    taskField.setText("");
                    taskCounter++; // Incrementare contor
                }
            }
        });

        JButton deleteButton = new JButton("Stergere task");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectIndex = taskList.getSelectedIndex();
                if(selectIndex != -1) {
                    taskListModel.remove(selectIndex);
                    updateTaskNumbers();
                }else {
                    JOptionPane.showMessageDialog(frame, "Selecteaza un task pentru a-l sterge");
                }
            }
        });



        frame.setLayout(new FlowLayout());
        frame.add(new JScrollPane(taskList));
        frame.add(taskField);
        frame.add(addButton);
        frame.add(deleteButton);
        frame.setVisible(true);
    }

    private void updateTaskNumbers() {
        DefaultListModel<String> updateModel = new DefaultListModel<>();
        for(int i = 0; i < taskListModel.size();i++){
            String task = taskListModel.get(i);
            String updateTask = (i+1)+". "+task.substring(task.indexOf(". ")+2);
            updateModel.addElement(updateTask);
        }
        taskListModel = updateModel;
        taskList.setModel(taskListModel);
    }

    public static void main(String[] args) {
        new ToDoListApp();
    }
}
