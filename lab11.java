// Lab 11 Hashing / Jaymee Hyppolite
public class main {
	public static void main(String[] args)
	   {
			//Driver for Q1
			try {
					for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
							if ("Nimbus".equals(info.getName())) {
								javax.swing.UIManager.setLookAndFeel(info.getClassName());
								break;
							}
					}
			} catch (ClassNotFoundException ex) {
				java.util.logging.Logger.getLogger(Hashing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			} catch (InstantiationException ex) {
				java.util.logging.Logger.getLogger(Hashing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			} catch (IllegalAccessException ex) {
				java.util.logging.Logger.getLogger(Hashing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			} catch (javax.swing.UnsupportedLookAndFeelException ex) {
				java.util.logging.Logger.getLogger(Hashing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			}


/* Create and display the form */
java.awt.EventQueue.invokeLater(new Runnable() {


public void run() {
new Hashing().setVisible(true);
}
});
		//Driver for Q2
	       // (a)A table size is 128 slots.
	       // Configure the slot size using tableSize
	       //variable and HashTable class
	       // constructor
	       int tableSize = 128;
	       HashTable<String> hashFunction = new HashTable<String>(tableSize);

	       // (b)The input data are randomly generated UNIQUE upper case data names
	       // with eight characters in length (Each name has to be unique).
	       RandomStringGenerator msr = new RandomStringGenerator();
	       for (int indx = 0; indx < tableSize; indx++)
	       {

	           // (c)Use the generated name for both key and Element value
	           // (KVpair.) you can use different key and value pair, in that case
	           // you have
	           // to invoke hashInsert(E k, E v) method.

	           if (!hashFunction.isFull())
	           {
	               hashFunction.hashInsert(msr.getRandomString());
	               // (f)Display the percentage of table
	               //had been occupied during the insertion.
	               System.out.println("Table is " + hashFunction.loading
	                       + "% full.....");
	           } else
	           {
	               // (e)Add those data names to the table start
	               //with empty table until the table is 40% full.
	               System.out.println("table is " + hashFunction.loading
	                       + "% full now ");
	               break;
	           }
	       }

	       hashFunction.printTable();

	       System.out.println("Total number of collision: "+countCollision);
	   }

}
import java.util.Hashtable;


public class Hashing extends javax.swing.JFrame {

/** Creates new form Hashing */
public Hashing() {
initComponents();
}


private void initComponents() {

word = new javax.swing.JTextField();
add = new javax.swing.JButton();
searchKey = new javax.swing.JTextField();
search = new javax.swing.JButton();
output = new javax.swing.JLabel();

setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

add.setText("Add word to the hashtable");
add.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
addActionPerformed(evt);
}
});

search.setText("Search word from the hashtable");
search.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
searchActionPerformed(evt);
}
});

output.setText(" ");

javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
getContentPane().setLayout(layout);
layout.setHorizontalGroup(
layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(layout.createSequentialGroup()
.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(layout.createSequentialGroup()
.addGap(39, 39, 39)
.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
.addGroup(layout.createSequentialGroup()
.addComponent(searchKey, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
.addGap(18, 18, 18)
.addComponent(search))
.addGroup(layout.createSequentialGroup()
.addComponent(word, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
.addGap(18, 18, 18)
.addComponent(add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
.addGroup(layout.createSequentialGroup()
.addGap(231, 231, 231)
.addComponent(output)))
.addContainerGap(62, Short.MAX_VALUE))
);
layout.setVerticalGroup(
layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(layout.createSequentialGroup()
.addGap(56, 56, 56)
.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
.addComponent(word, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
.addComponent(add))
.addGap(18, 18, 18)
.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
.addComponent(searchKey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
.addComponent(search))
.addGap(40, 40, 40)
.addComponent(output)
.addContainerGap(50, Short.MAX_VALUE))
);

pack();
}// </editor-fold>

private void addActionPerformed(java.awt.event.ActionEvent evt) {

hash.put(word.getText(), Integer.valueOf((int)(Math.random()*100)));
}

private void searchActionPerformed(java.awt.event.ActionEvent evt) {

Integer n = hash.get(searchKey.getText());
if (n != null)
output.setText("found");
else
output.setText("not found");
}




private javax.swing.JButton add;
private javax.swing.JLabel output;
private javax.swing.JButton search;
private javax.swing.JTextField searchKey;
private javax.swing.JTextField word;


Hashtable<String, Integer> hash = new Hashtable<String, Integer>();
}

public class HashTable<E>
{

   static int countCollision=0;
   private int M = 0;
   private int count = 0;
   @SuppressWarnings("rawtypes")
   private KVpair[] HT;
   private int loading = 0;

   // Generic array allocation
   public HashTable(int m)
   {
       M = m;
       HT = new KVpair[m];
   }

   boolean isFull() {
       loading = (count * 100) / M;
       return (loading >= 60) ? true : false;
   }

   void hashInsert(E k)
   {
       hashInsert(k, k);
   }

   void hashInsert(E k, E r)
   {

   
       if (r == null)
       {
           throw new NullPointerException();
       }

       // Makes sure the key is not already in the hashtable.
       KVpair[] tab = HT;
       int hash = new HashFunction().sfold((String) k, M);

      
       // int hash = hash(k);
       // int index = (hash & 0x7FFFFFFF) % tab.length;
       for (KVpair<E, E> e = tab[hash]; e != null; e = e.next)
       {
           countCollision++;
           if ((e.hash == hash) && e.key.equals(k))
           {
               E old = e.value;
               e.value = r;
               return;
           }
       }

       @SuppressWarnings("unchecked")
       KVpair<E, E> e = tab[hash];
       tab[hash] = new KVpair<>(hash, k, r, e);
       count++;
   }

   E search(E k)
   {
       @SuppressWarnings("rawtypes")
       KVpair tab[] = HT;
       int home = new HashFunction().sfold((String) k, M);
       int index = (home & 0x7FFFFFFF) % tab.length;
       for (@SuppressWarnings("unchecked")
       KVpair<E, E> e = tab[index]; e != null; e = e.next)
       {
           if ((e.hash == home) && e.key.equals(k))
           {
               return e.value;
           }
       }
       return null;
   }

   void printTable()
   {
       System.out.println("Hashtable Contents : ");
       for (int indx = 0; indx < HT.length; indx++)
       {
           System.out.println(HT[indx]);
       }
   }

   

   private static class KVpair<K, V> implements Map.Entry<K, V>
   {
       int hash;
       final K key;
       V value;
       KVpair<K, V> next;

       protected KVpair(int hash, K key, V value, KVpair<K, V> next)
       {
           this.hash = hash;
           this.key = key;
           this.value = value;
           this.next = next;
       }

       @SuppressWarnings("unchecked")
       protected Object clone() {
           return new KVpair<>(hash, key, value, (next == null ? null
                   : (KVpair<K, V>) next.clone()));
       }

     

       public K getKey()
       {
           return key;
       }

       public V getValue()
       {
           return value;
       }

       public V setValue(V value)
       {
           if (value == null)
               throw new NullPointerException();

           V oldValue = this.value;
           this.value = value;
           return oldValue;
       }

       @SuppressWarnings("rawtypes")
       public boolean equals(Object o)
       {
           if (!(o instanceof Map.Entry))
               return false;
           Map.Entry<?, ?> e = (Map.Entry) o;

           return key.equals(e.getKey()) && value.equals(e.getValue());
       }

       public int hashCode() {
           return (Objects.hashCode(key) ^ Objects.hashCode(value));
       }

       public String toString() {
           return key.toString() + "=" + value.toString();
       }
   }

}



package test;
class HashFunction
{

   int sfold(String s, int M)
   {
       int intLength = s.length() / 4;
       int sum = 0;
       for (int j = 0; j < intLength; j++)
       {
           char c[] = s.substring(j * 4, (j * 4) + 4).toCharArray();
           int mult = 1;
           for (int k = 0; k < c.length; k++)
           {
               sum += c[k] * mult;
               mult *= 256;
           }
       }
       char c[] = s.substring(intLength * 4).toCharArray();
       int mult = 1;
       for (int k = 0; k < c.length; k++)
       {
           sum += c[k] * mult;
           mult *= 256;
       }
       return (Math.abs(sum) % M);
   }
  
}

RandomStringGenerator.java:

package test;

import java.util.Random;

class RandomStringGenerator {

   private static final String CHAR_LIST_ALLOWED =
           "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
   private static final int STRING_LENGTH = 8;

   public String getRandomString() {

       StringBuffer randStr = new StringBuffer();
       for (int i = 0; i < STRING_LENGTH; i++) {
           int number = getRandomNumber();
           char ch = CHAR_LIST_ALLOWED.charAt(number);
           randStr.append(ch);
       }
       return randStr.toString();
   }

   private int getRandomNumber() {
       int randomInt = 0;
       Random random = new Random();
       randomInt = random.nextInt(CHAR_LIST_ALLOWED.length());
       if (randomInt - 1 == -1) {
           return randomInt;
       } else {
           return randomInt - 1;
       }
   }

}