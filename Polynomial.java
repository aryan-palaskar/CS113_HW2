import java.util.LinkedList;

public class Polynomial
{
    private LinkedList<Term> termList;

    public Polynomial()
    {
        this.termList = new LinkedList();
    }


    public Polynomial(Polynomial polynomial)
    {
        this.termList = new LinkedList();

        if (polynomial != null)
        {
            for (int i = 0; i < polynomial.getNumTerms(); i++)
            {
                termList.add(new Term(polynomial.getTerm(i)));
            }
        }
    }

    public void createPoly(String polynomial) {
        this.termList = new LinkedList();
        String[] terms = null;
        if(polynomial != null) {
            terms = polynomial.split("//+");
        }
        for(int i = 0; i < terms.length; i++) {
            termList.add(new Term(terms[i]));
        }
    }
    public void add(Polynomial polynomial)
    {
        for (int i = 0; i < polynomial.getNumTerms(); i++)
        {
            this.addTerm(polynomial.getTerm(i));
        }
    }


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
            for (int i = 0; i < this.getNumTerms() - 1; i++)
            {
                termCurrent = this.getTerm(i);
                termNext = this.getTerm(i + 1);

                // if term to add exponent bigger then current term's exponent
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

            lastIndex = this.getNumTerms() - 1;
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

    public Term remove(int index)
    {
        if (index < 0 || index > this.getNumTerms() - 1)
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

    public Term getTerm(int index)
    {
        return new Term(this.termList.get(index));
    }

    public void clear()
    {
        this.termList.clear();
    }

    public int getNumTerms()
    {
        return this.termList.size();
    }

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
            if (this.getNumTerms() != ((Polynomial) other).getNumTerms())
            {
                return false;
            }
            else
            {
                for (int i = 0; i < this.getNumTerms(); i++)
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

    @Override
    public String toString()
    {
        String temp;

        if (this.termList == null || this.termList.size() == 0)
        {
            temp = "0";
        }
        else
        {
            temp = "";

            for (Term term : termList)
            {
                temp += term.toString();
            }

            if (temp.charAt(0) == '+')
            {
                temp = temp.substring(1);
            }
        }

        return temp;
    }
}