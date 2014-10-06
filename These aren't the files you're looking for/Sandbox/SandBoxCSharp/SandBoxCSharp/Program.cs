using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SandBoxCSharp
{
    class Program
    {
        static void Main(string[] args)
        {
            Dictionary<int, string> test = new Dictionary<int, string>();
            test.Add(1, "init");
            test.Add(1, "end");
            Console.WriteLine(test[1]);
            Console.ReadLine();

        }
    }
}
