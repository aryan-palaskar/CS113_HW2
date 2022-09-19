import java.util.LinkedList;

public class Polynomial
{
    private LinkedList<Term> termList;

    //default constructor
    public Polynomial()
    {
        this.termList = new LinkedList();
    }

    //full constructor
    public Polynomial(Polynomial polynomial)
    {
        this.termList = new LinkedList();

        if (polynomial != null)
        {
            for (int i = 0; i < polynomial.getTotalTerms(); i++)
            {
                termList.add(new Term(polynomial.getTerm(i)));
            }
        }
    }

    //add method that adds two polynomials with the help of the addTerm method
    public void add(Polynomial polynomial)
    {
        for (int i = 0; i < polynomial.getTotalTerms(); i++)
        {
            this.addTerm(polynomial.getTerm(i));
        }
    }

    //method that adds two terms
    public void addTerm(Term termToAdd)
    {
        Term initialTerm, termCurrent, termNext, sum;
        int lastIndex;

        if (this.termList.size() == 0)
        {
            this.termList.add(termToAdd);
        }

        else if (this.termList.size() == 1)
        {
            initialTerm = termList.get(0);
            if (termToAdd.compareTo(initialTerm) == 1)
            {
                termList.add(0, termToAdd);
            }
            else if (termToAdd.compareTo(initialTerm) == 0)
            {
                sum = termToAdd.addition(initialTerm);
                if (sum != null)
                {
                    termList.set(0, sum);
                }
                else
                {
                    termList.remove(0);
                }
            }
            else
            {
                termList.add(termToAdd);
            }
        }
        else
        {
            for (int i = 0; i < this.getTotalTerms() - 1; i++)
            {
                termCurrent = this.getTerm(i);
                termNext = this.getTerm(i + 1);

                if (termToAdd.compareTo(termCurrent) == 1)
                {
                    termList.add(i, termToAdd);
                    return;
                }

                // else if term to Add Exponent matches current term's exponent
                else if (termToAdd.compareTo(termCurrent) == 0)
                {
                    sum = termToAdd.addition(termCurrent);
                    if (sum != null)
                    {
                        termList.set(i, sum);
                    }
                    else
                    {
                        termList.remove(i);
                    }
                    return;
                }

                if (termToAdd.compareTo(termCurrent) == -1
                        && termToAdd.compareTo(termNext) == 1)
                {

                    termList.add(i + 1, termToAdd);
                    return;
                }
            }

            lastIndex = this.getTotalTerms() - 1;
            initialTerm = this.getTerm(lastIndex);

            if (termToAdd.compareTo(initialTerm) == 0)
            {
                sum = termToAdd.addition(initialTerm);
                if (sum != null)
                {
                    termList.set(lastIndex, sum);
                }
                else
                {
                    termList.remove(lastIndex);
                }
            }
            else
            {
                termList.add(termToAdd);
            }
        }
    }

    //method that removes a term at a specific index
    public Term remove(int index)
    {
        if (index < 0 || index > this.getTotalTerms() - 1)
        {
            return null;
        }
        else
        {
            Term temp = new Term(this.getTerm(index));
            this.termList.remove(index);
            return temp;
        }
    }

    //getters and setters
    public Term getTerm(int index)
    {
        return new Term(this.termList.get(index));
    }

    //method to that returns the total number of terms in a polynomial
    public int getTotalTerms()
    {
        return this.termList.size();
    }

    //equals method to check if two polynomials are equal to each other
    @Override
    public boolean equals(Object other)
    {
        if (other == null || other.getClass() != this.getClass())
        {
            return false;
        }
        else
        {
            Polynomial otherPolynomial = (Polynomial) other;
            if (this.getTotalTerms() != ((Polynomial) other).getTotalTerms())
            {
                return false;
            }
            else
            {
                for (int i = 0; i < this.getTotalTerms(); i++)
                {
                    if (this.getTerm(i).getCoefficient() != otherPolynomial.getTerm(i).getCoefficient()
                            || this.getTerm(i).getExponent() != otherPolynomial.getTerm(i).getExponent())
                    {
                        return false;
                    }
                }
                return true;
            }
        }
    }

    //toString method to display the polynomial to the user
    @Override
    public String toString()
    {
        String polyTerm;

        if (this.termList == null || this.termList.size() == 0)
        {
            polyTerm = "0";
        }
        else
        {
            polyTerm = "";

            for(int i = 0; i < termList.size(); i++)
            {
                Term term = termList.get(i);
                polyTerm += term.toString();
            }

            if (polyTerm.charAt(0) == '+')
            {
                polyTerm = polyTerm.substring(1);
            }
        }

        return polyTerm;
    }

    //method that clears the polynomial
    public void clear()
    {
        this.termList.clear();
    }
}