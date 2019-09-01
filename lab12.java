// Lab 12 Javafx / Jaymee Hyppolite
public class main {
	public static void main(String[] args) {
        launch(args);
	}
}
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

class BSTAnimation extends Application {
    @Override
    public void start(Stage primaryStage) {
        BST<Integer> tree = new BST<>();

        BorderPane pane = new BorderPane();
        BTView view = new BTView(tree);
        pane.setCenter(view);

        TextField tfKey = new TextField();
        tfKey.setPrefColumnCount(3);
        tfKey.setAlignment(Pos.BASELINE_RIGHT);
        Button btInsert = new Button("Insert");
        Button btDelete = new Button("Delete");
        Button btSearch = new Button("Search");
        Button btInOrder = new Button("Inorder");
        Button btPreOrder = new Button("Preorder");
        Button btPostOrder = new Button("Postorder");
        Button btBreadthFirst = new Button("Breadth-First");
        Button btHeight = new Button("Height");
        HBox hBox = new HBox(5);
        hBox.getChildren().addAll(new Label("Enter a key: "),
                tfKey, btInsert, btDelete, btSearch, btInOrder, btPreOrder, btPostOrder, btBreadthFirst, btHeight);
        hBox.setAlignment(Pos.CENTER);
        pane.setBottom(hBox);

        btInsert.setOnAction(e -> {
            int key = Integer.parseInt(tfKey.getText());
            if (tree.search(key)) {
                view.displayTree();
                view.setStatus(key + " is already in the tree");
            }
            else {
                tree.insert(key);
                view.displayTree();
                view.setStatus(key + " is inserted in the tree");
            }
        });

        btDelete.setOnAction(e -> {
            int key = Integer.parseInt(tfKey.getText());
            if (!tree.search(key)) {
                view.displayTree();
                view.setStatus(key + " is not in the tree");
            }
            else {
                tree.delete(key);
                view.displayTree();
                view.setStatus(key + " is deleted from the tree");
            }
        });

        btSearch.setOnAction(e ->
        {
            int key = Integer.parseInt(tfKey.getText());
            if (!tree.search(key))
            {
                view.displayTree();
                view.setStatus(key + " is not in the tree");
            }
            else
            {
                view.searchPath(tree.path(key));
                view.displayTree();
                view.setStatus("Found " + key + " in the tree");
                view.searchPath(null);
            }
        });

        btInOrder.setOnAction(e ->
        {

            if (tree.isEmpty())
            {
                view.displayTree();
                view.setStatus("Tree is empty");
            }
            else
            {
                view.displayTree();
             
                view.setStatus("Inorder traversal: " + tree.inorderList().toString());
            }
        });

        btPreOrder.setOnAction(e ->
        {
            if (tree.isEmpty())
            {
                view.displayTree();
                view.setStatus("Tree is empty");
            }
            else
            {
                view.displayTree();
                view.setStatus("Preorder traversal: " + tree.preorderList().toString());
            }
        });

        btPostOrder.setOnAction(e ->
        {
            if (tree.isEmpty())
            {
                view.displayTree();
                view.setStatus("Tree is empty");
            }
            else
            {
                view.displayTree();
                view.setStatus("PostOrder traversal: " + tree.postorderList().toString());
            }
        });

        btBreadthFirst.setOnAction(e ->
        {
            if (tree.isEmpty())
            {
                view.displayTree();
                view.setStatus("Tree is empty");
            }
            else
            {
                view.displayTree();
                view.setStatus("Breadth-First Traversal: " + tree.breadthFirstOrderList().toString());
            }
        });

        btHeight.setOnAction(e ->
        {
            view.displayTree();
            view.setStatus("Tree height is " + tree.height());
        });

        Scene scene = new Scene(pane, 700, 250);
        primaryStage.setTitle("BSTAnimation");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
--------------------------------------------------------------------------------------------------------------------------------------------------------------------
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BST<E extends Comparable<E>> implements Tree<E> {
    protected TreeNode<E> root;
    protected int size = 0;

    public BST() {
    }

    public BST(E[] objects) {
        for (int i = 0; i < objects.length; i++)
            add(objects[i]);
    }

    @Override
    public boolean search(E e) {
        TreeNode<E> current = root;

        while (current != null) {
            if (e.compareTo(current.element) < 0) {
                current = current.left;
            }
            else if (e.compareTo(current.element) > 0) {
                current = current.right;
            }
            else
                return true;
        }

        return false;
    }

    @Override
    public boolean insert(E e) {
        if (root == null)

            root = createNewNode(e);
        else {
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while (current != null)
                if (e.compareTo(current.element) < 0) {
                    parent = current;
                    current = current.left;
                }
                else if (e.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                }
                else
                    return false;
            if (e.compareTo(parent.element) < 0)
                parent.left = createNewNode(e);

            else
                parent.right = createNewNode(e);
        }

        size++;
        return true;
    }

    protected TreeNode<E> createNewNode(E e) {
        return new TreeNode<>(e);
    }

    @Override
    public void inorder() {
        inorder(root);
    }

    protected void inorder(TreeNode<E> root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.element + " ");
        inorder(root.right);
    }

    @Override
    public void postorder() {
        postorder(root);
    }

    protected void postorder(TreeNode<E> root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.element + " ");
    }

    @Override
    public void preorder() {
        preorder(root);
    }

    protected void preorder(TreeNode<E> root) {
        if (root == null) return;
        System.out.print(root.element + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static class TreeNode<E> {
        protected E element;
        protected TreeNode<E> left;
        protected TreeNode<E> right;

        public TreeNode(E e) {
            element = e;
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    public TreeNode<E> getRoot() {
        return root;
    }

    public java.util.ArrayList<TreeNode<E>> path(E e) {
        java.util.ArrayList<TreeNode<E>> list =
                new java.util.ArrayList<>();
        TreeNode<E> current = root;

        while (current != null) {
            list.add(current);
            if (e.compareTo(current.element) < 0) {
                current = current.left;
            }
            else if (e.compareTo(current.element) > 0) {
                current = current.right;
            }
            else
                break;
        }

        return list;
    }

    @Override
    public boolean delete(E e) {
        TreeNode<E> parent = null;
        TreeNode<E> current = root;
        while (current != null) {
            if (e.compareTo(current.element) < 0) {
                parent = current;
                current = current.left;
            }
            else if (e.compareTo(current.element) > 0) {
                parent = current;
                current = current.right;
            }
            else
                break;
        }

        if (current == null)
            return false;

        if (current.left == null) {
            if (parent == null) {
                root = current.right;
            }
            else {
                if (e.compareTo(parent.element) < 0)
                    parent.left = current.right;
                else
                    parent.right = current.right;
            }
        }
        else {
            TreeNode<E> parentOfRightMost = current;
            TreeNode<E> rightMost = current.left;

            while (rightMost.right != null) {
                parentOfRightMost = rightMost;
                rightMost = rightMost.right;
            }

            current.element = rightMost.element;

            if (parentOfRightMost.right == rightMost)
                parentOfRightMost.right = rightMost.left;
            else
                parentOfRightMost.left = rightMost.left;
        }

        size--;
        return true;
    }

    @Override
    public java.util.Iterator<E> iterator() {
        return new InorderIterator();
    }

    private class InorderIterator implements java.util.Iterator<E> {
        private java.util.ArrayList<E> list =
                new java.util.ArrayList<>();
        private int current = 0;
        private boolean canRemove = false;

        public InorderIterator() {
            inorder();
        }

        private void inorder() {
            inorder(root);
        }

        private void inorder(TreeNode<E> root) {
            if (root == null) return;
            inorder(root.left);
            list.add(root.element);
            inorder(root.right);
        }

        @Override
        public boolean hasNext() {
            return current < list.size();
        }

        @Override
        public E next() {
            if (hasNext())
                canRemove = true;
            else
                throw new java.util.NoSuchElementException();
            return list.get(current++);
        }

        @Override
        public void remove() {
            if (!canRemove)
                throw new IllegalStateException();
            else {
                delete(list.get(--current));
                canRemove = false;
            }

            list.clear();
            inorder();
        }
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    public java.util.List<E> inorderList()
    {
        List<E> list = new ArrayList<E>();
        inorderList(root, list);
        return list;
    }
    private void inorderList(TreeNode<E> root, List<E> list)
    {
        if (root == null)
            return;
        inorderList(root.left, list);
        list.add(root.element);
        inorderList(root.right, list);

    }


    public java.util.List<E> preorderList()
    {
        List<E> list = new ArrayList<E>();
        preorderList(root, list);
        return list;

    }
    private void preorderList(TreeNode<E> root, List<E> list)
    {
        if (root == null)
            return;
        list.add(root.element);
        preorderList(root.left, list);
        preorderList(root.right, list);
    }


    public java.util.List<E> postorderList()
    {
        List<E> list = new ArrayList<E>();
        postorderList(root, list);
        return list;
    }
    private void postorderList(TreeNode<E> root, List<E> list)
    {
        if (root == null)
            return;
        postorderList(root.left, list);
        postorderList(root.right, list);
        list.add(root.element);
    }

    public java.util.List<E> breadthFirstOrderList()
    {
        Queue<TreeNode<E>> q = new LinkedList<TreeNode<E>>();
        List<E> list = new ArrayList<E>();
        q.add(root);
        while(!q.isEmpty())
        {
            TreeNode<E> node = q.remove();
            list.add(node.element);
            if (node.left != null)
                q.add(node.left);
            if (node.right != null)
                q.add(node.right);
        }
        return list;

    }

    public int height()
    {
        if (size == 0)
            return -1;
        else if (size == 1)
            return 0;
        else
        {
            return height(root) - 1;
        }
    }
    public int height(TreeNode<E> root)
    {
        if (root == null)
            return 0;
        else
            return 1 + Math.max(height(root.left), height(root.right));

    }
}


--------------------------------------------------------------------------------------------------------------------------------------------------------------------
import java.util.List;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class BTView extends Pane {
    private BST<Integer> tree = new BST<>();
    private double radius = 15;
    private double vGap = 50;
    private List<?> path;

    BTView(BST<Integer> tree) {
        this.tree = tree;
        setStatus("Tree is empty");
    }

    public <E> void searchPath(List<E> list)
    {
        path = list;
    }

    public void setStatus(String msg) {
        getChildren().add(new Text(20, 20, msg));
    }

    public void displayTree() {
        this.getChildren().clear();
        if (tree.getRoot() != null) {
            displayTree(tree.getRoot(), getWidth() / 2, vGap,
                    getWidth() / 4);
        }
    }


    private void displayTree(BST.TreeNode<Integer> root,
                             double x, double y, double hGap) {
        if (root.left != null) {
            getChildren().add(new Line(x - hGap, y + vGap, x, y));
            displayTree(root.left, x - hGap, y + vGap, hGap / 2);
        }

        if (root.right != null) {
            getChildren().add(new Line(x + hGap, y + vGap, x, y));
            displayTree(root.right, x + hGap, y + vGap, hGap / 2);
        }

        Circle circle = new Circle(x, y, radius);
        circle.setFill(Color.WHITE);
        if(path!=null && !path.isEmpty())
        {
            if(path.contains(root))
                circle.setFill(Color.ORANGE);
        }
        circle.setStroke(Color.BLACK);
        getChildren().addAll(circle,
                new Text(x - 4, y + 4, root.element + ""));
    }
}


--------------------------------------------------------------------------------------------------------------------------------------------------------------------
import java.util.Collection;

public interface Tree<E> extends java.util.Collection<E> {
    public boolean search(E e);

    public boolean insert(E e);

    public boolean delete(E e);

    public int getSize();

    public default void inorder() {
        throw new UnsupportedOperationException();
    }

    public default void postorder() {
    }

    public default void preorder() {
    }

    @Override
    public default boolean isEmpty() {
        return size() == 0;
    };

    @Override
    public default boolean contains(Object e) {
        return search((E)e);
    }

    @Override
    public default boolean add(E e) {
        return insert(e);
    }

    @Override
    public default boolean remove(Object e) {
        return delete((E)e);
    }

    @Override
    public default int size() {
        return getSize();
    }

    @Override
    public default boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public default boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public default boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public default boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public default Object[] toArray() {
        return null;
    }

    @Override
    public default <T> T[] toArray(T[] array) {
        return null;
    }
}
--------------------------------------------------------------------------------------------------------------------------------------------------------------------
