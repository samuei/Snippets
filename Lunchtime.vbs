' Declarations
Dim arrsize
Dim index
Dim quotearray()
Dim quote

' Deal with VBScript's awful arrays
arrsize = 6
ReDim quotearray(arrsize)

' Define variable quotes
quotearray(0) = "They say time is the fire in which we burn."
quotearray(1) = "Time is an illusion. Lunchtime, doubly so."
quotearray(2) = "Don't touch that! It's my lunch."
quotearray(3) = "People assume that time is a strict progression of cause to effect, but actually, from a non-linear, non-subjective viewpoint, it's more like a big ball of wibbly-wobbly, timey-wimey...stuff."
quotearray(4) = "Thought is the arrow of time; memory never fades."
quotearray(5) = "Time keeps on slippin', slippin', slippin' into the future..."
quotearray(6) = "STOP! Hammer Time!"

' Get random index
Randomize
index = Int(Rnd() * 100) MOD arrsize

' Get quote at that index
quote = quotearray(index)

' Get my attention, hopefully
MsgBox "Get your stuff together, change your Pidgin status, and clock out" & vbcrlf & vbcrlf & quote, vbSystemModal, "Lunchtime!"
