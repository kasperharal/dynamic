# alpha-omega
alpha-omega is a markup language

## scalar types
- **null:** empty value  
*syntax:* `null`  
*note:* this type will act as missing value for every thing except a null check
- **bool:** true or false  
*syntax:* `true` | `false`
- **integer:**  integral numbers  
*syntax:* `123` | `-123`  
*suffix:*  
    - (`h` | `H` | `x` | `X`) → hexadecimal  
    - (`o` | `O`) → octal  
    - (`b` | `B`) → binary  
- **number:**  floating-point numbers  
*syntax:* `123.123` | `-123.123`
*suffix:* (`f` | `F`) → floating-point
- **string:** character sequence  
*syntax:* `"..."` | `'...'`  
*patterns:* 
    - `\b` → backspace
    - `\t` → tab
    - `\n` → line feed | new line 
    - `\f` → form feed
    - `\r` → carriage return
    - `\s` → space
    - `\"` → double qoute
    - `\'` → single qoute
    - `\0 - \377` → octal escape
## compund types
- **list:** sequenced list of values  
*syntax:* `[...]`
- **set:** a special form of unorderd list with no dublicates
*syntax:* `![...]`
- **map:**  key value pairs  
*syntax:* `{...}` *label:* `abc:`
- **table:** table of referenced pairs   
*syntax:* `(...)` *reference:* `->`
## complex types