
import unittest
from unittest import suite
import wordsOccurences

class TestMyCode(unittest.TestCase):

    def test_count_words_occurences(self):
        self.assertEqual([('the', 56), ('and', 30), ('I', 27), ('my', 24), 
        ('of', 21), ('that', 16), ('a', 15), ('this', 12), ('chamber', 11),
        ('is', 9), ('bird', 9), ('at', 8), ('with', 7), ('soul', 7), 
        ('no', 7), ('or', 7), ('above', 7), ('from', 7), ('Raven,', 7), ('there', 6)], 
        wordsOccurences.count_words_occurences(filename=r"c:\Users\VQHSon\Desktop\UnitTest\Poem.txt"))

def main():
    # create the suite for test cases above
    suite = unittest.TestLoader().loadTestsFromTestCase(TestMyCode)
    # run the test cases
    unittest.TextTestRunner(verbosity=3).run(suite)

main()

