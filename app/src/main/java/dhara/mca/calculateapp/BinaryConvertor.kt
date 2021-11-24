package dhara.mca.calculateapp

import java.lang.StringBuilder

object BinaryConvertor {

    //convert text to binary
    fun strToBinary(str:String) : String{
        var builder = StringBuilder()

        for(c in str.toCharArray()){
            //get char value in binary
            var toString = Integer.toString(c.toInt(),2)
            //to have 8 digits
            builder.append(String.format("%08d",Integer.parseInt(toString)))
        }
        return builder.toString()
    }
    //convert binary to text
    fun binaryToString(binary:String) : String{
        if(!isBinary(binary))
            return "Not a Binary Vlaue"
        var chars = CharArray(binary.length / 8)
        var i = 0

        while(i < binary.length){
            var str = binary.substring(i, i+8)
            var nb = Integer.parseInt(str, 2)
            chars[i / 8] = nb.toChar()
            i +=8
        }
        return  String(chars)
    }
    //Check if string represents a binary number or no
    fun isBinary(txt:String):Boolean{
        if (txt != null && txt.length % 8 == 0){
            for(c in txt.toCharArray()){
                if(c != '0' && c!='1')
                    return false
            }
            return true
        }
        return false
    }
}