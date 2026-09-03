import java.awt.*;
import java.awt.event.*;
import java.util.Stack;
import javax.swing.*;

public class ParagraphStackExplorer extends JFrame {

    // Components
    private JTextArea txtSourceParagraph;
    private JTextField txtWord;
    private JTextArea txtStackResult;
    private JLabel lblStackStatus;

    private JButton btnLoadParagraph;
    private JButton btnDisplayStack;
    private JButton btnReverseParagraph;
    private JButton btnPushWord;
    private JButton btnSearchPosition;
    private JButton btnPeekTop;
    private JButton btnPopTop;
    private JButton btnClearStack;
    
    private Stack<String> words;

    public ParagraphStackExplorer() {
        initComponents();
        addListeners();
    }

    private void initComponents() {

        // -------------------------------------------------
        // FRAME
        // -------------------------------------------------
        setTitle("Target GUI: Paragraph Stack Explorer");
        setSize(912, 572);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main panel
        JPanel mainPanel = new JPanel(new BorderLayout(5, 5));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        // -------------------------------------------------
        // TOP SECTION
        // -------------------------------------------------
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));

        JLabel lblTitle = new JLabel("Target GUI: Paragraph Stack Explorer");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 22));
        lblTitle.setForeground(new Color(130, 90, 0));

        JLabel lblDescription = new JLabel(
                "The source is always a large paragraph. Each private listener class answers one Stack question through a specific button."
        );

        topPanel.add(lblTitle);
        topPanel.add(Box.createVerticalStrut(10));
        topPanel.add(lblDescription);
        topPanel.add(Box.createVerticalStrut(10));

        // -------------------------------------------------
        // MAIN CONTENT PANEL
        // -------------------------------------------------
        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBorder(
                BorderFactory.createTitledBorder(
                        BorderFactory.createLineBorder(Color.GRAY),
                        "Paragraph Stack Explorer",
                        javax.swing.border.TitledBorder.CENTER,
                        javax.swing.border.TitledBorder.TOP,
                        new Font("Arial", Font.BOLD, 14)
                )
        );

        // -------------------------------------------------
        // SOURCE PARAGRAPH SECTION
        // -------------------------------------------------
        JPanel sourcePanel = new JPanel(new BorderLayout(5, 5));

        JLabel lblSource = new JLabel("Source paragraph");
        lblSource.setFont(new Font("Arial", Font.BOLD, 14));

        txtSourceParagraph = new JTextArea();
        txtSourceParagraph.setLineWrap(true);
        txtSourceParagraph.setWrapStyleWord(true);
        txtSourceParagraph.setRows(5);

        txtSourceParagraph.setText(
                "Stacks process values in last-in-first-out order. "
                + "A paragraph can be cleaned into words, and every word can be pushed onto the stack. "
                + "The final word becomes the top item."
        );

        JScrollPane sourceScrollPane = new JScrollPane(txtSourceParagraph);

        sourcePanel.add(lblSource, BorderLayout.NORTH);
        sourcePanel.add(sourceScrollPane, BorderLayout.CENTER);

        // -------------------------------------------------
        // FIRST BUTTON ROW
        // -------------------------------------------------
        JPanel buttonPanel1 = new JPanel(new FlowLayout(FlowLayout.LEFT, 7, 0));

        btnLoadParagraph = new JButton("Load Paragraph");
        btnDisplayStack = new JButton("Display Stack");
        btnReverseParagraph = new JButton("Reverse Paragraph");

        buttonPanel1.add(btnLoadParagraph);
        buttonPanel1.add(btnDisplayStack);
        buttonPanel1.add(btnReverseParagraph);

        // -------------------------------------------------
        // WORD INPUT SECTION
        // -------------------------------------------------
        JPanel wordPanel = new JPanel(new BorderLayout(7, 0));

        txtWord = new JTextField();
        txtWord.setText("Enter a word...");

        JPanel wordButtons = new JPanel(new FlowLayout(FlowLayout.LEFT, 7, 0));

        btnPushWord = new JButton("Push Word");
        btnSearchPosition = new JButton("Search Position");

        wordButtons.add(btnPushWord);
        wordButtons.add(btnSearchPosition);

        wordPanel.add(txtWord, BorderLayout.CENTER);
        wordPanel.add(wordButtons, BorderLayout.EAST);

        // -------------------------------------------------
        // SECOND BUTTON ROW
        // -------------------------------------------------
        JPanel buttonPanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 7, 0));

        btnPeekTop = new JButton("Peek Top");
        btnPopTop = new JButton("Pop Top");
        btnClearStack = new JButton("Clear Stack");

        buttonPanel2.add(btnPeekTop);
        buttonPanel2.add(btnPopTop);
        buttonPanel2.add(btnClearStack);

        // -------------------------------------------------
        // STACK RESULT
        // -------------------------------------------------
        JPanel resultPanel = new JPanel(new BorderLayout(5, 5));

        JLabel lblResult = new JLabel("Stack visualisation / result");
        lblResult.setFont(new Font("Arial", Font.BOLD, 14));

        txtStackResult = new JTextArea();
        txtStackResult.setLineWrap(true);
        txtStackResult.setWrapStyleWord(true);

        txtStackResult.setText(
                "TOP → item\\n stack\\n the\\n onto\\n ..."
        );

        JScrollPane resultScrollPane = new JScrollPane(txtStackResult);

        resultPanel.add(lblResult, BorderLayout.NORTH);
        resultPanel.add(resultScrollPane, BorderLayout.CENTER);

        // -------------------------------------------------
        // STATUS LABEL
        // -------------------------------------------------
        lblStackStatus = new JLabel(
                "Stack size: 28 | Top: item | Stack is not empty",
                SwingConstants.CENTER
        );

        lblStackStatus.setFont(new Font("Arial", Font.BOLD, 14));
        lblStackStatus.setForeground(new Color(130, 90, 0));

        lblStackStatus.setBorder(
                BorderFactory.createLineBorder(Color.GRAY)
        );
        
        words = new Stack<>();

        // -------------------------------------------------
        // PUT EVERYTHING TOGETHER
        // -------------------------------------------------
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        centerPanel.add(sourcePanel);
        centerPanel.add(Box.createVerticalStrut(7));
        centerPanel.add(buttonPanel1);
        centerPanel.add(Box.createVerticalStrut(7));
        centerPanel.add(wordPanel);
        centerPanel.add(Box.createVerticalStrut(7));
        centerPanel.add(buttonPanel2);
        centerPanel.add(Box.createVerticalStrut(7));
        centerPanel.add(resultPanel);

        contentPanel.add(centerPanel, BorderLayout.CENTER);
        contentPanel.add(lblStackStatus, BorderLayout.SOUTH);

        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(contentPanel, BorderLayout.CENTER);

        add(mainPanel);
    }

    // =====================================================
    // ADD LISTENERS
    // =====================================================

    private void addListeners() {

        btnLoadParagraph.addActionListener(new LoadParagraphListener());

        btnDisplayStack.addActionListener(new DisplayStackListener());

        btnReverseParagraph.addActionListener(new ReverseParagraphListener());

        btnPushWord.addActionListener(new PushWordListener());

        btnSearchPosition.addActionListener(new SearchPositionListener());

        btnPeekTop.addActionListener(new PeekTopListener());

        btnPopTop.addActionListener(new PopTopListener());

        btnClearStack.addActionListener(new ClearStackListener());
    }

    // =====================================================
    // PRIVATE LISTENER CLASSES
    // =====================================================

    private class LoadParagraphListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            // YOUR CODE HERE
            words.clear();
            
            String paragraph = txtSourceParagraph.getText().trim();
            
            String cleanedText = paragraph.toLowerCase().replaceAll("[^a-z ]", " ").replaceAll("\\s+", " ").trim();
            
            if(cleanedText.isEmpty())
            {
                lblStackStatus.setText("Enter paragraph first.");
                
                return;
            }
            
            String[] parts = cleanedText.split("\\s+");
            
            for(String part: parts)
            {
                words.push(part);
            }
            
            lblStackStatus.setText("Stack size:" + words.size() + " | Top:" + words.peek() + " | Stack is not empty");
        }
    }

    // -----------------------------------------------------

    private class DisplayStackListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            // YOUR CODE HERE
            txtStackResult.setText("");
            
            Stack<String> copy = new Stack<>();
            copy.addAll(words);
            
            int position = 1;
            
            while(!copy.empty())
            {
                txtStackResult.append(position +"."+ copy.pop() + "\n");
                position++;
            }
        }
    }

    // -----------------------------------------------------

    private class ReverseParagraphListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            // YOUR CODE HERE
            Stack<String> copy = new Stack<>();
            
            copy.addAll(words);
            
            String reversed = "";
            
            while(!copy.empty())
            {
                reversed += copy.pop() + " ";
            }
            
            txtStackResult.setText(reversed.trim());
        }
    }

    // -----------------------------------------------------

    private class PushWordListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            // YOUR CODE HERE
            String word = txtWord.getText().toLowerCase().replaceAll("[^a-z ]", " ").trim();
            
            if(word.isEmpty())
            {
                lblStackStatus.setText("Enter one valid word.");
                
                return;
            }
            
            words.push(word);
            
            lblStackStatus.setText(word + " pushed to the top.");

        }
    }

    // -----------------------------------------------------

    private class SearchPositionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            // YOUR CODE HERE
            String target = txtWord.getText().replaceAll("[^a-z ]", " ").trim();
            
            int position = words.search(target);
            
            if(position == -1)
            {
                lblStackStatus.setText(target + " was not found.");
            }
            else
            {
                lblStackStatus.setText(target + " was found at position " + position);
            }
        }
    }

    // -----------------------------------------------------

    private class PeekTopListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            // YOUR CODE HERE
            if(words.empty())
            {
                lblStackStatus.setText("Cannot peek: Stack is empty.");
            }
            else
            {
                lblStackStatus.setText("Top of the stack " + words.peek());
            }

        }
    }

    // -----------------------------------------------------

    private class PopTopListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            // YOUR CODE HERE
            if(words.empty())
            {
                lblStackStatus.setText("Cannot pop: Stack is empty.");
            }
            else
            {
                lblStackStatus.setText(words.pop() + " successfully poped. " + words.size() + " items remain.");
            }
        }
    }

    // -----------------------------------------------------

    private class ClearStackListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            // YOUR CODE HERE
            words.clear();
            txtStackResult.setText("");
            lblStackStatus.setText(
                    "The Stack has been cleared.");
        }
    }

    // =====================================================
    // MAIN
    // =====================================================

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new ParagraphStackExplorer().setVisible(true);
        });
    }
}