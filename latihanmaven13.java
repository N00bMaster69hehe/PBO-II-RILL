
package latianmaven13;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class latihanmaven13 {
    private static ArrayList<Product> products = new ArrayList<>();
    private static DefaultTableModel tableModel;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Daftar Produk");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        String[] columnNames = {"Nama Produk", "Harga"};
        tableModel = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(tableModel);
        
        JTextField nameField = new JTextField(10);
        JTextField priceField = new JTextField(10);
        JButton addButton = new JButton("Tambah");
        JLabel messageLabel = new JLabel();

        addButton.addActionListener(e -> {
            String name = nameField.getText().trim();
            String priceText = priceField.getText().trim();
            
            if (name.isEmpty()) {
                messageLabel.setText("Nama produk tidak boleh kosong.");
                return;
            }
            
            try {
                double price = Double.parseDouble(priceText);
                Product product = new Product(name, price);
                products.add(product);
                tableModel.addRow(new Object[]{name, price});
                nameField.setText("");
                priceField.setText("");
                messageLabel.setText("Produk berhasil ditambahkan.");
            } catch (NumberFormatException ex) {
                messageLabel.setText("Harga harus berupa angka.");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Nama:"));
        panel.add(nameField);
        panel.add(new JLabel("Harga:"));
        panel.add(priceField);
        panel.add(addButton);
        
        // Adding message label to the panel
        panel.add(messageLabel);
        
        frame.add(new JScrollPane(table), BorderLayout.CENTER);
        frame.add(panel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}

class Product {
    String name;
    double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}
