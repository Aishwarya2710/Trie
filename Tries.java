public class Trie
{
    char c;
    Trie[] children;
    boolean word_exists;
    Trie()
    {
        this.c = 0;
        this.children = new Trie[26];
        this.word_exists = false;
    }
    public void insert(String s)
    {
        if(s.length()== 0)
            this.word_exists = true;
        else
        {
            char letter = s.charAt(0);
            if(this.children[letter-'a'] == null)
                this.children[letter-'a'] = new Trie();
            this.children[letter-'a'].insert(s.substring(1));
        }
    }
    public boolean isWord(String s)
    {
        if(s.length() == 0)
            return this.word_exists;
        char letter = s.charAt(0);
        if(this.children[letter-'a'] == null)
            return false;
        return this.children[letter-'a'].isWord(s.substring(1));
    }
    public static void main(String[] args)
    {
        Trie root = new Trie();
        root.insert("hey");
        root.insert("hello");
        root.insert("try");
        root.insert("tries");
        boolean result = root.isWord("tries");
        System.out.println(result);
    }
}
