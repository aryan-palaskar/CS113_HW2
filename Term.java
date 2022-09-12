
public class Term implements Cloneable, Comparable
{

    // Class variables
    private int coefficient;
    private int exponent;

    public Term()
    {
        this.setAll(1, 1);
    }

    public Term(int coefficient, int exponent)
    {
        this.setAll(coefficient, exponent);
    }

    public Term(Term other)
    {
        if (other == null)
        {
            throw new NullPointerException();
        }
        else
        {
            this.setAll(other.getCoefficient(), other.getExponent());
        }
    }

    public Term(String term)
    {
        int coefficient, exponent;

        if (!term.isEmpty())
        {

            if (term.contains(Character.toString('x')))
            {
                String[] splitTerm = term.split(Character.toString('x'));

                coefficient = parseCoefficientString(splitTerm[0]);

                if (splitTerm.length == 2)
                {
                    exponent = parseExponentString(splitTerm[1]);
                }
                else
                {
                    exponent = 1;
                }
            }
            else
            {
                coefficient = parseCoefficientString(term);
                exponent = 0;
            }
        }
        else
        {
            coefficient = exponent = 0;
        }

        this.setAll(coefficient, exponent);
    }

    private int parseCoefficientString(String str)
    {
        if (str.length() == 1 && str.charAt(0) == '-')
        {
            return -1;
        }
        else if (str.length() == 1 && str.charAt(0) == '+')
        {
            return 1;
        }
        else
        {
            return Integer.parseInt(str);
        }
    }

    private int parseExponentString(String str)
    {
        return Integer.parseInt(str.substring(1));
    }

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

    public Object clone() {
        Term t1 = new Term();
        t1.setAll(this.getCoefficient(), this.getExponent());
        Object other = (Object) t1;
        return other;
    }


    public int compareTo(Object o)
    {
        Term other = (Term) o;
        if (this.exponent > other.getExponent())
        {
            return 1;
        }
        else if (this.exponent < other.getExponent())
        {
            return -1;
        }
        else
        {
            return 0;
        }
    }

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

    public String toString()
    {
        String temp = "";

        if (this.coefficient != 0)
        {


            if (coefficient > 0)
            {
                temp += '+';
                if (coefficient > 1)
                {
                    temp += this.coefficient;
                }
            }
            else
            {
                if (coefficient == -1)
                {
                    temp += '-';
                }
                else
                {
                    temp += this.coefficient;
                }
            }

            if (this.exponent != 0)
            {
                temp += 'x';

                if (this.exponent > 1 || this.exponent < -1)
                {
                    temp += '^' + "" + this.exponent;
                }
            }
        }
        return temp;
    }

    public Term addition(Term other)
    {
        return sum(this, other);
    }

    public static Term sum(Term termA, Term termB)
    {
        Term other = null;
        int coefficientSum;

        if (termA.exponent == termB.exponent)
        {
            coefficientSum = termA.coefficient + termB.coefficient;

            if (coefficientSum == 0)
            {
                return null;
            }
            else
            {
                other = new Term(coefficientSum, termA.exponent);
            }

        }
        return other;
    }
}




