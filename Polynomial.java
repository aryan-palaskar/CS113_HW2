import java.util.LinkedList;

public class Polynomial
{
    private LinkedList<Term> polyList;

    //default constructor
    public Polynomial()
    {
        this.polyList = new LinkedList();
    }

    //full constructor
    public Polynomial(Polynomial polynomial)
    {
        this.polyList = new LinkedList();

        if (polynomial != null)
        {
            for (int i = 0; i < polynomial.getTotalTerms(); i++)
            {
                polyList.add(new Term(polynomial.getTerm(i)));
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
        int index;

        //if no terms
        if (this.polyList.size() == 0)
        {
            this.polyList.add(termToAdd);
        }

        //if only one term is present
        else if (this.polyList.size() == 1)
        {
            initialTerm = polyList.get(0);

            //if termtoAdd greater
            if (termToAdd.compareTo(initialTerm) == 1)
            {
                polyList.add(0, termToAdd);
            }

            //if termToAdd same
            else if (termToAdd.compareTo(initialTerm) == 0)
            {
                sum = termToAdd.addition(initialTerm);
                if (sum != null)
                {
                    polyList.set(0, sum);
                }
                else
                {
                    polyList.remove(0);
                }
            }
            else
            {
                polyList.add(termToAdd);
            }
        }
        else
        {
            //if more than one term is present
            for (int i = 0; i < this.getTotalTerms() - 1; i++)
            {
                termCurrent = this.getTerm(i);
                termNext = this.getTerm(i + 1);

                //if termToAdd is greater than the current term
                if (termToAdd.compareTo(termCurrent) == 1)
                {
                    polyList.add(i, termToAdd);
                    return;
                }

                // else if term to Add Exponent matches current term's exponent
                else if (termToAdd.compareTo(termCurrent) == 0)
                {
                    sum = termToAdd.addition(termCurrent);
                    if (sum != null)
                    {
                        polyList.set(i, sum);
                    }
                    else
                    {
                        polyList.remove(i);
                    }
                    return;
                }

                if (termToAdd.compareTo(termCurrent) == -1
                        && termToAdd.compareTo(termNext) == 1)
                {

                    polyList.add(i + 1, termToAdd);
                    return;
                }
            }

            index = this.getTotalTerms() - 1;
            initialTerm = this.getTerm(index);

            if (termToAdd.compareTo(initialTerm) == 0)
            {
                sum = termToAdd.addition(initialTerm);
                if (sum != null)
                {
                    polyList.set(index, sum);
                }
                else
                {
                    polyList.remove(index);
                }
            }
            else
            {
                polyList.add(termToAdd);
            }
        }
    }

    //method that removes a term at a specific index
    public Term remove(int index)
    {
            Term temp = new Term(this.getTerm(index));
            this.polyList.remove(index);
            return temp;
    }

    //getters and setters
    public Term getTerm(int index)
    {
        return new Term(this.polyList.get(index));
    }

    //method to that returns the total number of terms in a polynomial
    public int getTotalTerms()
    {
        return this.polyList.size();
    }

    //equals method to check if two polynomials are equal to each other
    @Override
    public boolean equals(Object other)
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

    //toString method to display the polynomial to the user
    @Override
    public String toString()
    {
        String polyTerm;

        if (this.polyList == null || this.polyList.size() == 0)
        {
            polyTerm = "0";
        }
        else
        {
            polyTerm = "";

            for(int i = 0; i < polyList.size(); i++)
            {
                Term term = polyList.get(i);
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
        this.polyList.clear();
    }
}