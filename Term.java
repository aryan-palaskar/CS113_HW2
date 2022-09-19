
public class Term implements Cloneable, Comparable
{

    // Class variables
    private int coefficient;
    private int exponent;

    //default constructor
    public Term()
    {
        this.setAll(1, 1);
    }

    //full constructor
    public Term(int coefficient, int exponent)
    {
        this.setAll(coefficient, exponent);
    }

    //instantiate a new term with a given term as the parameter
    public Term(Term other)
    {
        this.setAll(other.getCoefficient(), other.getExponent());
    }

    //String constructor that passes string as a parameter
    public Term(String term)
    {
        int coefficient, exponent;

        if (term != null)
        {

            if (term.contains(Character.toString('x')))
            {
                String[] splitTerm = term.split(Character.toString('x'));

                if (splitTerm[0].length() == 1 && splitTerm[0].charAt(0) == '-')
                {
                    coefficient = -1;
                }
                else if (splitTerm[0].length() == 1 && splitTerm[0].charAt(0) == '+')
                {
                    coefficient = 1;
                }
                else
                {
                    coefficient = Integer.parseInt(splitTerm[0]);
                }

                if (splitTerm.length == 2)
                {
                    exponent = Integer.parseInt(splitTerm[1].substring(1));
                }
                else
                {
                    exponent = 1;
                }
            }
            else
            {
                if (term.length() == 1 && term.charAt(0) == '-')
                {
                    coefficient = -1;
                }
                else if (term.length() == 1 && term.charAt(0) == '+')
                {
                    coefficient = 1;
                }
                else
                {
                    coefficient = Integer.parseInt(term);
                }
                exponent = 0;
            }
        }
        else
        {
            coefficient = exponent = 0;
        }

        this.setAll(coefficient, exponent);
    }

    //getters and setters for the variables
    public void setCoefficient(int value)
    {
        this.coefficient = value;
    }

    public void setExponent(int value)
    {
        this.exponent = value;
    }

    public void setAll(int coefficient, int exponent)
    {
        this.setCoefficient(coefficient);
        this.setExponent(exponent);
    }

    public int getCoefficient()
    {
        return this.coefficient;
    }

    public int getExponent()
    {
        return this.exponent;
    }

    //clone method to clone a term
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    //compare method to check if a Term is greater, less or same
    public int compareTo(Object o)
    {
        Term other = (Term) o;
        return Integer.compare(this.exponent, other.getExponent());
    }

    //equals method to check if two terms are equal
    public boolean equals(Object other)
    {
        if (other == null || other.getClass() != this.getClass())
        {
            return false;
        }
        else
        {
            Term otherTerm = (Term) other;
            return this.coefficient == otherTerm.getCoefficient()
                    && this.exponent == otherTerm.getExponent();
        }
    }

    //toString method for displaying the term with appropriate signs
    public String toString()
    {
        String termString = "";

        if (this.coefficient != 0)
        {
            if (coefficient > 0)
            {
                termString += '+';
                if (coefficient > 1)
                {
                    termString += this.coefficient;
                }
            }
            else
            {
                if (coefficient == -1)
                {
                    termString += '-';
                }
                else
                {
                    termString += this.coefficient;
                }
            }

            if (this.exponent != 0)
            {
                termString += 'x';

                if (this.exponent > 1 || this.exponent < -1)
                {
                    termString += '^' + "" + this.exponent;
                }
            }
        }
        return termString;
    }

    //method to perform addition of two term using the sum method
    public Term addition(Term other)
    {
        return sum(this, other);
    }

    //method to calculate the sum of two terms
    public static Term sum(Term term1, Term term2)
    {
        Term other = null;
        int coefficientSum;

        if (term1.exponent == term2.exponent)
        {
            coefficientSum = term1.coefficient + term2.coefficient;

            if (coefficientSum == 0)
            {
                return null;
            }
            else
            {
                other = new Term(coefficientSum, term1.exponent);
            }

        }
        return other;
    }
}




